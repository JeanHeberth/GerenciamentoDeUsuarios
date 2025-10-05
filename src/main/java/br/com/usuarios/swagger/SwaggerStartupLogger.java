package br.com.usuarios.swagger;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
public class SwaggerStartupLogger {

    @Value("${server.port}")
    private String port;

    @Value("${server.servlet.context-path:}")
    private String contextPath;

    @PostConstruct
    public void logSwaggerUrls() {
        try {
            // Detecta automaticamente o IP local
            String localIp = InetAddress.getLocalHost().getHostAddress();
            // Endereço fixo de rede (se quiser deixar dinâmico, posso te mostrar)
            String networkIp = "100.83.72.100";

            // Monta as URLs
            String localUrl = "http://localhost:" + port + contextPath;
            String networkUrl = "http://" + networkIp + ":" + 9999 + contextPath;

            System.out.println("\n------------------------------------------------------------");
            System.out.println("Swagger UI disponível em: " + localUrl + "/swagger-ui/index.html");
            System.out.println("OpenAPI Docs: " + localUrl + "/v3/api-docs");
            System.out.println();
            System.out.println("🌐 Acesso via rede local: " + networkUrl + "/swagger-ui/index.html");
            System.out.println("🌐 Docs (Rede): " + networkUrl + "/v3/api-docs");
            System.out.println("------------------------------------------------------------\n");

        } catch (Exception e) {
            System.err.println("Erro ao detectar IP local: " + e.getMessage());
        }
    }
}
