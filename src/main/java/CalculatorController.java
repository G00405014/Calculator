// 1. Create a new Spring Boot project: Not shown here, use Spring Initializr or Spring Tool Suite.

// 2. Create the CalculatorController class
@RestController
public class CalculatorController {

    // 3. Create the Response inner class
    public static class Response {
        private String operation;
        private double total;

        // Getters and setters for operation and total...
    }

    // 4. Create the calculate method
    @GetMapping("/calculate")
    public Response calculate(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operation) {

        double result = 0;
        switch (operation.toLowerCase()) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }

        Response response = new Response();
        response.setOperation(operation.toLowerCase());
        response.setTotal(result);

        return response;
    }
}
