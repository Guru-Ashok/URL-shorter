package com.urlshortener.main;

import com.urlshortener.repository.UrlRepository;
import com.urlshortener.service.UrlShortenerService;
import java.util.Scanner;

// Main Layer - User Interface (Console)
public class Main {
    public static void main(String[] args) {
        UrlRepository repository = new UrlRepository();
        UrlShortenerService service = new UrlShortenerService(repository);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== URL SHORTENER =====");
            System.out.println("1. Shorten URL");
            System.out.println("2. Retrieve Original URL");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the long URL: ");
                    String longUrl = scanner.nextLine();
                    String shortUrl = service.shortenUrl(longUrl);
                    System.out.println("Shortened URL: " + shortUrl);
                    break;

                case 2:
                    System.out.print("Enter the short URL: ");
                    String shortInput = scanner.nextLine();
                    String original = service.getOriginalUrl(shortInput);
                    if (original != null)
                        System.out.println("Original URL: " + original);
                    else
                        System.out.println("No mapping found!");
                    break;

                case 3:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
