package bo.edu.ucb.msclientpago.dto;

import java.util.Date;

public class PaymentDTO {
    private Long id;

    private Long idUser;
    private String cardNumber;
    private String cardHolderName;
    private double amount;
    private Date paymentDate;
    private String paymentStatus;
    private String paymentDescription;

    public PaymentDTO(Long id, Long idUser, String cardNumber, String cardHolderName, double amount, Date paymentDate, String paymentStatus, String paymentDescription) {
        this.id = id;
        this.idUser = idUser;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        this.paymentDescription = paymentDescription;
    }

    public PaymentDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }
}
