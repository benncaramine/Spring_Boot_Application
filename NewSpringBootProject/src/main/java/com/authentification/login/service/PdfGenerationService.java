package com.authentification.login.service;

import com.authentification.login.entitiy.Abonnement;
import com.authentification.login.entitiy.User;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

@Service
public class PdfGenerationService {

    private byte[] downloadUserPhoto(String photoUrl) throws Exception {
        URL url = new URL(photoUrl);
        try (InputStream inputStream = url.openStream()) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            // Vérifier si les données téléchargées représentent une image valide
            Image.getInstance(outputStream.toByteArray()); // Cela lèvera une exception si les données ne représentent pas une image valide
            return outputStream.toByteArray();
        }
    }

    public byte[] generateUserCardPdf(User user, Abonnement abonnement) throws Exception {
        // Télécharger la photo de l'utilisateur à partir de l'URL
        String photoUrl = "https://cdn-icons-png.flaticon.com/512/3177/3177440.png";
        byte[] userPhoto = downloadUserPhoto(photoUrl);

        float mmToPoints = 2.834f;
        Rectangle cardSize = new Rectangle(85.60f * mmToPoints, 53.98f * mmToPoints);
        Document document = new Document(cardSize, 36, 36, 20, 36);
        // Créer un nouveau document PDF

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);

        // Ouvrir le document pour écrire
        document.open();

        // Ajouter le contenu au document
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 9, Font.BOLD, new BaseColor(0, 102, 204));
        Paragraph title = new Paragraph("CARTE D'ABONNEMENT: \n ", titleFont);
        title.setAlignment(Element.ALIGN_LEFT);
        document.add(title);
        // Ajouter un espacement après le titre

// Ajouter un espacement après le titre
        document.add(new Paragraph());
        if (userPhoto != null && userPhoto.length > 0) {
            Image image = Image.getInstance(userPhoto);
            image.scaleToFit(50, 50); // Redimensionner l'image si nécessaire

            // Determine the right margin position for the image
            float xPosition = document.getPageSize().getWidth() - image.getScaledWidth() - document.rightMargin();
            float yPosition = document.getPageSize().getHeight() - image.getScaledHeight() - document.topMargin();

            // Set the absolute position of the image
            image.setAbsolutePosition(xPosition, yPosition);

            // Add the image to the document
            document.add(image);
        }


        // Ajouter les informations de l'utilisateur au document
        Paragraph userInfo = new Paragraph();
        Font infoFont = FontFactory.getFont(FontFactory.HELVETICA, 6, Font.BOLD, new BaseColor(51, 51, 51));
        Font infoFont2 = FontFactory.getFont(FontFactory.HELVETICA, 6, Font.BOLD, new BaseColor(0, 102, 204));

        userInfo.add(new Chunk("Votre ID : ", infoFont2));
        userInfo.add(new Chunk(user.getId() + "\n", infoFont));
        userInfo.add(new Chunk("Nom d'utilisateur : ", infoFont2));
        userInfo.add(new Chunk(user.getUsername() + "\n", infoFont));
        userInfo.add(new Chunk("Date d'inscription : ", infoFont2));
        userInfo.add(new Chunk(abonnement.getDate_inscription() + "\n", infoFont));
        userInfo.add(new Chunk("Date d'expiration : ", infoFont2));
        userInfo.add(new Chunk(abonnement.getDate_expiration() + "\n", infoFont));

        document.add(userInfo);

        // Ajouter un espacement après les informations de l'utilisateur
        // document.add(new Paragraph("\n"));

        // Ajouter la photo de l'utilisateur au document


        // Fermer le document
        document.close();

        return outputStream.toByteArray();
    }
}
