import java.util.Scanner;
public class SCT_SD_01 {
        // Conversion methods
        public static double celsiusToFahrenheit(double c) {
            return (c * 9 / 5) + 32;
        }
        public static double celsiusToKelvin(double c) {
            return c + 273.15;
        }
        public static double fahrenheitToCelsius(double f) {
            return (f - 32) * 5 / 9;
        }
        public static double fahrenheitToKelvin(double f) {
            return (f - 32) * 5 / 9 + 273.15;
        }
        public static double kelvinToCelsius(double k) {
            return k - 273.15;
        }
        public static double kelvinToFahrenheit(double k) {
            return (k - 273.15) * 9 / 5 + 32;
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Temperature Conversion to All Scales ===");
            System.out.print("Enter the temperature value: ");
            double temp = scanner.nextDouble();
            System.out.print("Enter the input scale (C/F/K): ");
            char scale = scanner.next().toUpperCase().charAt(0);
            double celsius = 0, fahrenheit = 0, kelvin = 0;
            boolean valid = true;
            switch (scale) {
                case 'C':
                    celsius = temp;
                    fahrenheit = celsiusToFahrenheit(temp);
                    kelvin = celsiusToKelvin(temp);
                    break;
                case 'F':
                    celsius = fahrenheitToCelsius(temp);
                    fahrenheit = temp;
                    kelvin = fahrenheitToKelvin(temp);
                    break;
                case 'K':
                    celsius = kelvinToCelsius(temp);
                    fahrenheit = kelvinToFahrenheit(temp);
                    kelvin = temp;
                    break;
                default:
                    valid = false;
                    System.out.println("Invalid scale. Use C, F, or K.");
            }
            if (valid) {
                System.out.printf("\nCelsius: %.2f C\n", celsius);
                System.out.printf("Fahrenheit: %.2f F\n", fahrenheit);
                System.out.printf("Kelvin: %.2f K\n", kelvin);
            }
            scanner.close();
        }
    }



