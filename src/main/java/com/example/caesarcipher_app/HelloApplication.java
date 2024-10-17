package com.example.caesarcipher_app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.regex.Pattern;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.Scanner;
import java.nio.file.Files;
import java.util.List;


class EncryptionAndDecryption {
    private final String input;
    private int shift;


    public EncryptionAndDecryption(String input, int shift) {
        this.input = input;
        this.shift = shift;
    }

    char[] rus_alfabetLower = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    char[] rus_alfabetUpper = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Ч', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};
    char[] eng_alfabetLower = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char[] eng_alfabetUpper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    StringBuilder result = new StringBuilder();
    boolean found = false;

    public String russianEncrypt() {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            found = false;
            for (int j = 0; j < rus_alfabetLower.length; j++) {
                if (currentChar == rus_alfabetLower[j]) {
                    result.append(rus_alfabetLower[(j + shift) % rus_alfabetLower.length]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                for (int j = 0; j < rus_alfabetUpper.length; j++) {
                    if (currentChar == rus_alfabetUpper[j]) {
                        result.append(rus_alfabetUpper[(j + shift) % rus_alfabetUpper.length]);
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public String russianDecrypt() {

        shift = rus_alfabetLower.length;
        int shiftForResult=0;
        StringBuilder results = new StringBuilder();

        while (shift > 0) {
            StringBuilder decrypt_result = new StringBuilder();
            shift--;

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                found=false;
                for (int j = 0; j < rus_alfabetLower.length; j++) {
                    if (currentChar == rus_alfabetLower[j]) {
                        decrypt_result.append(rus_alfabetLower[(j - shift + rus_alfabetLower.length) % rus_alfabetLower.length]);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    for (int j = 0; j < rus_alfabetUpper.length; j++) {
                        if (currentChar == rus_alfabetUpper[j]) {
                            decrypt_result.append(rus_alfabetUpper[(j - shift + rus_alfabetUpper.length) % rus_alfabetUpper.length]);
                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
                    decrypt_result.append(currentChar);
                }

            }
            shiftForResult+=1;
            results.append("Расшифрованная строка: ").append(decrypt_result).append(", сдвиг: ").append(shiftForResult).append("\n");
        }
        return results.toString();
    }


    public String englishEncrypt() {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            found = false;
            for (int j = 0; j < eng_alfabetLower.length; j++) {
                if (currentChar == eng_alfabetLower[j]) {
                    result.append(eng_alfabetLower[(j + shift) % eng_alfabetLower.length]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                for (int j = 0; j < eng_alfabetUpper.length; j++) {
                    if (currentChar == eng_alfabetUpper[j]) {
                        result.append(eng_alfabetUpper[(j + shift) % eng_alfabetUpper.length]);
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public String englishDecrypt() {

        shift = eng_alfabetLower.length;
        int shiftForResult=0;
        StringBuilder results = new StringBuilder();

        while (shift > 0) {
            StringBuilder decrypt_result = new StringBuilder();
            shift--;

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                found=false;
                for (int j = 0; j < eng_alfabetLower.length; j++) {
                    if (currentChar == eng_alfabetLower[j]) {
                        decrypt_result.append(eng_alfabetLower[(j - shift + eng_alfabetLower.length) % eng_alfabetLower.length]);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    for (int j = 0; j < eng_alfabetUpper.length; j++) {
                        if (currentChar == eng_alfabetUpper[j]) {
                            decrypt_result.append(eng_alfabetUpper[(j - shift + eng_alfabetUpper.length) % eng_alfabetUpper.length]);
                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
                    decrypt_result.append(currentChar);
                }

            }
            shiftForResult+=1;
            results.append("Расшифрованная строка: ").append(decrypt_result).append(", сдвиг: ").append(shiftForResult).append("\n");
        }
        return results.toString();
    }
}



public class HelloApplication extends Application {
    private static final Scanner scanner = new Scanner(System.in);

    private TextArea inputArea;
    private TextArea outputArea;
    private ComboBox<String> languageCombo;
    private ToggleGroup actionGroup;
    private TextField shiftField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Шифрование методом Цезаря");

        languageCombo = new ComboBox<>();
        languageCombo.getItems().addAll("Русский", "Английский");
        languageCombo.setValue("Русский");

        inputArea = new TextArea();
        inputArea.setPromptText("Введите строку для шифрования/дешифрования");

        shiftField = new TextField();
        shiftField.setPromptText("Введите сдвиг (не 0)");

        actionGroup = new ToggleGroup();
        RadioButton encryptButton = new RadioButton("Зашифровать");
        encryptButton.setToggleGroup(actionGroup);
        RadioButton decryptButton = new RadioButton("Расшифровать");
        decryptButton.setToggleGroup(actionGroup);
        encryptButton.setSelected(true);

        outputArea = new TextArea();
        outputArea.setEditable(false);

        Button processButton = new Button("Обработать");
        processButton.setOnAction(e -> processInput());

        Button fileButton = new Button("Выбрать файл");
        fileButton.setOnAction(e -> chooseFile());

        VBox layout = new VBox(10, languageCombo, inputArea, shiftField, encryptButton, decryptButton, processButton, fileButton, outputArea);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void processInput() {
        String input = inputArea.getText();
        if (input.isEmpty()) {
            outputArea.setText("Пожалуйста, введите текст для обработки.");
            return;
        }
        String language = languageCombo.getValue();
        String action = ((RadioButton) actionGroup.getSelectedToggle()).getText();

        int shift;
        try {
            shift = Integer.parseInt(shiftField.getText());
            if (shift == 0 ||
                    (language.equals("Русский") && Math.abs(shift) > 32) ||
                    (language.equals("Английский") && Math.abs(shift) > 25)) {
                outputArea.setText("Введите корректный сдвиг. Если язык работы русский, сдвиг должен быть от -32 до 32, не считая 0, в случае английского - от -25 до 25, не считая 0.");
                return;
            }
        } catch (NumberFormatException e) {
            outputArea.setText("\"Введите корректный сдвиг. Если язык работы русский, сдвиг должен быть от -32 до 32, не считая 0, в случае английского - от -25 до 25, не считая 0.");
            return;
        }

        if (language.equals("Русский")) {
            if (!isRus(input)) {
                outputArea.setText("Введите текст полностью на русском языке.");
                return;
            }
            EncryptionAndDecryption cipher = new EncryptionAndDecryption(input, shift);
            String result = action.equals("Зашифровать") ? cipher.russianEncrypt() : cipher.russianDecrypt();
            outputArea.setText(result);
        } else {
            if (!isEnglish(input)) {
                outputArea.setText("Введите текст полностью на английском языке.");
                return;
            }
            EncryptionAndDecryption cipher = new EncryptionAndDecryption(input, shift);
            String result = action.equals("Зашифровать") ? cipher.englishEncrypt() : cipher.englishDecrypt();
            outputArea.setText(result);
        }
    }

    private void chooseFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выбрать файл");
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            try {
                List<String> lines = Files.readAllLines(file.toPath());
                StringBuilder content = new StringBuilder();
                for (String line : lines) {
                    content.append(line).append("\n");
                }
                inputArea.setText(content.toString());


                shiftField.setText("1");

                processFile(file);
            } catch (Exception e) {
                outputArea.setText("Ошибка чтения файла.");
            }
        }
    }

    private void processFile(File file) {
        String input = inputArea.getText();
        String language = languageCombo.getValue();
        int shift;

        try {
            shift = Integer.parseInt(shiftField.getText());
            if (shift == 0 ||
                    (language.equals("Русский") && Math.abs(shift) > 32) ||
                    (language.equals("Английский") && Math.abs(shift) > 25)) {
                outputArea.setText("Введите корректный сдвиг.");
                return;
            }
        } catch (NumberFormatException e) {
            outputArea.setText("Введите корректный сдвиг.");
            return;
        }

        if (language.equals("Русский")) {
            EncryptionAndDecryption cipher = new EncryptionAndDecryption(input, shift);
            String result = cipher.russianEncrypt();
            outputArea.setText(result);
        } else {
            EncryptionAndDecryption cipher = new EncryptionAndDecryption(input, shift);
            String result = cipher.englishEncrypt();
            outputArea.setText(result);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


    private static boolean isEnglish(String input){
        return Pattern.matches("^[a-zA-Z0-9,.!?;:\"'()\\[\\]{}\\s-]*$", input);
    }
    private static boolean isRus(String input){
        return Pattern.matches("^[а-яА-ЯёЁ0-9,.!?;:\"'()\\[\\]{}\\s-]*$", input);
    }
}

