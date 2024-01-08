package com.design.patterns.behavioral.strategy;

import java.math.BigDecimal;

// Payment Strategy Interface
interface PaymentStrategy {
    void processPayment(BigDecimal amount);
}

// Balance View Strategy Interface
interface BalanceViewStrategy {
    BigDecimal viewBalance();
}

// Credit Card Payment Strategy
class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;
    private String expirationDate;

    public CreditCardPaymentStrategy(String cardNumber, String expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    @Override
    public void processPayment(BigDecimal amount) {
        System.out.println("Processing credit card payment of $" + amount +
                " with card number " + cardNumber + " and expiration date " + expirationDate);
        // Specific logic for processing credit card payment
    }
}

// PayPal Payment Strategy
class PayPalPaymentStrategy implements PaymentStrategy {
    private String email;

    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(BigDecimal amount) {
        System.out.println("Processing PayPal payment of $" + amount + " with email " + email);
        // Specific logic for processing PayPal payment
    }
}

// Mobile App Balance View Strategy
class MobileAppBalanceViewStrategy implements BalanceViewStrategy {
    private String userId;

    public MobileAppBalanceViewStrategy(String userId) {
        this.userId = userId;
    }

    @Override
    public BigDecimal viewBalance() {
        // Simulating fetching balance from mobile app for a user
        System.out.println("Viewing balance on mobile app for user " + userId);
        return new BigDecimal("1000.50"); // Simulated balance
    }
}

// Web App Balance View Strategy
class WebAppBalanceViewStrategy implements BalanceViewStrategy {
    private String userId;

    public WebAppBalanceViewStrategy(String userId) {
        this.userId = userId;
    }

    @Override
    public BigDecimal viewBalance() {
        // Simulating fetching balance from web app for a user
        System.out.println("Viewing balance on web app for user " + userId);
        return new BigDecimal("750.25"); // Simulated balance
    }
}

// Context for payment processing
class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(BigDecimal amount) {
        paymentStrategy.processPayment(amount);
    }
}

// Context for viewing balance
class BalanceViewer {
    private BalanceViewStrategy balanceViewStrategy;

    public void setBalanceViewStrategy(BalanceViewStrategy balanceViewStrategy) {
        this.balanceViewStrategy = balanceViewStrategy;
    }

    public BigDecimal viewBalance() {
        return balanceViewStrategy.viewBalance();
    }
}

// Example usage
class PaymentExample {
    public static void main(String[] args) {
        // Payment with credit card
        PaymentProcessor creditCardProcessor = new PaymentProcessor();
        creditCardProcessor.setPaymentStrategy(new CreditCardPaymentStrategy("1234-5678-9101-1121", "12/25"));
        creditCardProcessor.processPayment(new BigDecimal("100.50"));

        // Payment with PayPal
        PaymentProcessor payPalProcessor = new PaymentProcessor();
        payPalProcessor.setPaymentStrategy(new PayPalPaymentStrategy("example@example.com"));
        payPalProcessor.processPayment(new BigDecimal("75.25"));

        // View balance on mobile app
        BalanceViewer mobileAppBalanceViewer = new BalanceViewer();
        mobileAppBalanceViewer.setBalanceViewStrategy(new MobileAppBalanceViewStrategy("mobile_user"));
        BigDecimal mobileAppBalance = mobileAppBalanceViewer.viewBalance();
        System.out.println("Balance on mobile app: $" + mobileAppBalance);

        // View balance on web app
        BalanceViewer webAppBalanceViewer = new BalanceViewer();
        webAppBalanceViewer.setBalanceViewStrategy(new WebAppBalanceViewStrategy("web_user"));
        BigDecimal webAppBalance = webAppBalanceViewer.viewBalance();
        System.out.println("Balance on web app: $" + webAppBalance);
    }
}
