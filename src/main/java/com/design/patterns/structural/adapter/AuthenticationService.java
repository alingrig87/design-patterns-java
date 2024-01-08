package com.design.patterns.structural.adapter;

// Standardized interface for authentication in the new system
interface AuthenticationService {
    void authenticate(String username, String password);
}

// Old service that needs to be adapted
class LegacyAuthenticationService {
    void legacyAuthenticate(String user, String pass) {
        System.out.println("Legacy authentication for user: " + user);
        // Old authentication logic
    }
}

// Adapter that makes the old service fit the new interface
class LegacyAuthenticationAdapter implements AuthenticationService {
    private LegacyAuthenticationService legacyAuthService;

    // Constructor that receives an instance of the old service
    public LegacyAuthenticationAdapter(LegacyAuthenticationService legacyAuthService) {
        this.legacyAuthService = legacyAuthService;
    }

    // Implementation of the authenticate method from the new interface, which delegates to legacyAuthenticate
    @Override
    public void authenticate(String username, String password) {
        System.out.println("Adapter is calling legacyAuthenticate for user: " + username);
        legacyAuthService.legacyAuthenticate(username, password);
    }
}

// New service with the updated authentication mechanism
class NewAuthenticationService implements AuthenticationService {
    @Override
    public void authenticate(String username, String password) {
        System.out.println("New authentication for user: " + username);
        // New authentication logic
    }
}

// Client code using both old and new authentication mechanisms
class AdapterPatternExample {
    public static void main(String[] args) {
        // Create an instance of the old service
        LegacyAuthenticationService legacyAuthService = new LegacyAuthenticationService();

        // Create an adapter that uses the old service
        AuthenticationService legacyAdapter = new LegacyAuthenticationAdapter(legacyAuthService);

        // Use the new standardized authentication service
        AuthenticationService newService = new NewAuthenticationService();

        // Authenticate using the old service through the adapter
        legacyAdapter.authenticate("john_doe", "password123");

        // Authenticate using the new service directly
        newService.authenticate("jane_doe", "new_password");
    }
}
