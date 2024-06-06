package br.edu.inteli.backend.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    private final Path sharedFolderPath = Paths.get("../planejador/src/main/resources");

    @PostMapping("/upload")
    public String uploadXML(@RequestParam("file") MultipartFile file) {

        System.out.println("Recebendo arquivo: " + file.getOriginalFilename());

        if (file.isEmpty()) {
            return "O arquivo está vazio";
        }

        try {
            // Verificar se o diretório existe, se não, criar
            if (!Files.exists(sharedFolderPath)) {
                Files.createDirectories(sharedFolderPath);
            }

            // Salvar o arquivo na pasta shared
            Path destinationFilePath = sharedFolderPath.resolve(file.getOriginalFilename());
            file.transferTo(destinationFilePath);

            return "Arquivo salvo com sucesso em: " + destinationFilePath;
        } catch (Exception e) {
            return "Erro ao salvar o arquivo: " + e.getMessage();
        }
    }
}
