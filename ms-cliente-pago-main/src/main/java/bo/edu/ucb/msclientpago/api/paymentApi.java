package bo.edu.ucb.msclientpago.api;

import bo.edu.ucb.msclientpago.bl.PaymentBl;
import bo.edu.ucb.msclientpago.dao.entity.PaymentDAO;
import bo.edu.ucb.msclientpago.dto.PaymentDTO;
import bo.edu.ucb.msclientpago.dto.PaymentRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/payment")
@RestController
public class paymentApi {
    @Autowired
    private PaymentBl paymentBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(paymentApi.class);

    @PostMapping("/pay")
    public ResponseEntity<String> makePayment(@RequestBody PaymentRequestDTO paymentRequest) {
        // Valida y procesa el pago (esto es simplificado)
        boolean paymentSuccessful = paymentBl.processPayment(paymentRequest);

        if (paymentSuccessful) {
            return ResponseEntity.ok("Payment successful");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment failed");
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> savePayment(@RequestBody PaymentDTO paymentDTO) {
        paymentBl.savePayment(paymentDTO);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Payment saved");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/list")
    public ResponseEntity<List<PaymentDAO>> getPaymentsByUserId(@RequestParam("userId") Long userId) {
        LOGGER.info("Empezando funcion para obtener lista de pagos por usuario");
        List<PaymentDAO> payments = paymentBl.getPaymentsByUserId(userId);
        return ResponseEntity.ok(payments);

        //return ResponseEntity.ok("hola");
    }

    //Este endpoint sera para obtener un pago mediante el id
    @GetMapping("/id/{id}")
    public String getPaymentById(@PathVariable("id") Long id){
        LOGGER.info("Empezando funcion de obtener pago mediante el id");
        LOGGER.info("este es el id: "+id);
        return "hola: "+id;
    }



    @GetMapping("/testconn")
    public String testConn() {
        return "OK";
    }

}
