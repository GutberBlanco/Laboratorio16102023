package bo.edu.ucb.msclientpago.bl;

import bo.edu.ucb.msclientpago.dao.entity.PaymentDAO;
import bo.edu.ucb.msclientpago.dao.repository.PaymentRepository;
import bo.edu.ucb.msclientpago.dto.PaymentDTO;
import bo.edu.ucb.msclientpago.dto.PaymentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentBl {
    @Autowired
    private PaymentRepository paymentRepository;

    public boolean processPayment(PaymentRequestDTO paymentRequest) {
        // Aquí se simula el procesamiento de pago.
        // Verifica si la tarjeta es válida y otros controles de seguridad.
        if (isValidCard(paymentRequest)) {
            // Realiza el pago y registra la transacción en la base de datos.
            // Devuelve true si el pago se realizó con éxito.
            // De lo contrario, devuelve false.
            return performPayment(paymentRequest);
        }

        // Si la tarjeta no es válida o hay un problema en el procesamiento, devuelve false.
        return false;
    }
    private boolean isValidCard(PaymentRequestDTO paymentRequest) {
        // Lógica para verificar si la tarjeta es válida.
        // Implementa tus validaciones aquí.
        // Por ejemplo, puedes verificar la fecha de vencimiento, el CVV, etc.
        return true; // En este ejemplo, siempre se considera válida.
    }
    private boolean performPayment(PaymentRequestDTO paymentRequest) {
        // Lógica para realizar el pago real.
        // Esto puede implicar una llamada a una pasarela de pago, registro en la base de datos, etc.
        // Implementa esta lógica según la pasarela de pago que estés utilizando.
        // Devuelve true si el pago se realizó con éxito.
        // De lo contrario, devuelve false.

        return true; // En este ejemplo, siempre se considera exitoso.
    }
    public List<PaymentDAO> getPaymentsByUserId(Long userId) {
        Iterable<PaymentDAO> payments = paymentRepository.findByIdUser(userId);

        List<PaymentDAO> result = new ArrayList<>();
        payments.forEach(result::add);
        return result;
    }

    public void savePayment(PaymentDTO paymentDTO) {
        PaymentDAO payment = convertToDAO(paymentDTO);
        paymentRepository.save(payment);
    }
    public PaymentDAO convertToDAO(PaymentDTO paymentDTO) {
        PaymentDAO payment = new PaymentDAO();
        payment.setId(paymentDTO.getId());
        payment.setAmount(paymentDTO.getAmount());
        payment.setCardHolderName(paymentDTO.getCardHolderName());
        payment.setCardNumber(paymentDTO.getCardNumber());
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setPaymentDescription(paymentDTO.getPaymentDescription());
        payment.setPaymentStatus(paymentDTO.getPaymentStatus());
        payment.setIdUser(paymentDTO.getIdUser());
        return payment;
    }

    private PaymentDTO convertToDTO(PaymentDAO payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setAmount(payment.getAmount());
        dto.setCardHolderName(payment.getCardHolderName());
        dto.setCardNumber(payment.getCardNumber());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setPaymentDescription(payment.getPaymentDescription());
        dto.setPaymentStatus(payment.getPaymentStatus());
        dto.setIdUser(payment.getIdUser());
        return dto;
    }

}
