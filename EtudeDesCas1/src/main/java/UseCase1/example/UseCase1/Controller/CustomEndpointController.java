package UseCase1.example.UseCase1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/actuator")
public class CustomEndpointController {

    @Autowired
    private RefreshEndpoint refreshEndpoint;

    @PostMapping("/refresh")
    public String refresh() {
        return refreshEndpoint.refresh().toString();
    }

}
