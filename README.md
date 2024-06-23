# Marajó Ticket Sales Controller
Visão Geral
O Marajó Ticket Sales Controller é um sistema desenvolvido em Java com Spring Boot para gerenciar a venda de passagens de barcos com destino à Ilha do Marajó, no Pará. Este projeto utiliza uma arquitetura baseada em microservices para modularidade e escalabilidade.

# Componentes Principais
- Eureka Server (Service Discovery)

- Responsável por registrar e descobrir os microservices dentro da arquitetura.
- API Gateway (Zuul)

# Encaminha as requisições dos clientes para os microservices apropriados e oferece funcionalidades como autenticação e logging.
- Booking Service
    - Gerencia as reservas de passagens, incluindo criação, consulta, atualização e cancelamento de reservas.
- Schedule Service
    - Gerencia os horários de partida dos barcos, permitindo que os clientes consultem os horários disponíveis.
- User Service
    - Responsável pelo gerenciamento de usuários, incluindo registro, autenticação e informações do perfil do usuário.
- Payment Service
    - Gerencia o fluxo de pagamentos das passagens, integrando-se com provedores de pagamento externos para processar transações de compra.
- Boat Service
    - Mantém informações detalhadas sobre os barcos, incluindo capacidade máxima e mínima de passageiros, garantindo que as reservas respeitem essas restrições.
## Fluxo de Funcionamento
### Reserva de Passagens:

Os usuários podem visualizar os horários disponíveis através do Schedule Service.
O Booking Service permite aos usuários realizar reservas de passagens para os horários desejados, respeitando a capacidade dos barcos.
Pagamento:

Após a seleção dos horários e a confirmação da reserva, o Payment Service facilita o processo de pagamento através de integrações com provedores de pagamento.
Autenticação e Segurança:

O User Service gerencia a autenticação dos usuários, garantindo que apenas usuários autorizados possam realizar reservas e pagamentos.
Tecnologias Utilizadas
Java
Spring Boot
Spring Cloud (Eureka Server, Zuul)
Spring Data JPA
PostgreSQL (ou MySQL)
RESTful APIs
Integração com provedores de pagamento externos (opcional, dependendo dos requisitos)
Como Executar o Projeto
Para executar o Marajó Ticket Sales Controller localmente, siga as instruções de cada serviço conforme detalhado nos respectivos diretórios (booking-service, schedule-service, user-service, payment-service, boat-service). Certifique-se de configurar corretamente as dependências e o banco de dados antes de iniciar os serviços.

Contribuição
Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões para melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.