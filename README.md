📦 Storeflow BFF

Backend for Frontend (BFF) do projeto Storeflow, responsável por intermediar a comunicação entre o frontend (Angular) e o backend principal (storeflow-srv).

🧠 CONTEXTO DO PROJETO

O Storeflow é um projeto de estudo focado em desenvolvimento backend profissional, simulando a base de um e-commerce / marketplace.

A arquitetura é composta por:

Frontend (Angular)
        ↓
BFF (Spring Boot)
        ↓
SRV (Spring Boot)
        ↓
PostgreSQL

🎯 OBJETIVO DO BFF

O storeflow-bff tem como responsabilidades:

consumir os endpoints do storeflow-srv
adaptar dados para o frontend
centralizar regras de integração
preparar o sistema para autenticação futura (JWT)
desacoplar o frontend do backend principal

⚙️ TECNOLOGIAS UTILIZADAS
Java 21
Spring Boot
Spring Web
Spring Security (configuração básica)
Spring Cloud OpenFeign
Lombok
Maven

🧱 ARQUITETURA INTERNA

Estrutura atual:

controller → service → client (Feign) → SRV
                     ↓
                    DTO
Controller → expõe API para o frontend
Service → orquestra chamadas
Client (Feign) → comunicação com SRV
DTO → contratos de entrada/saída
📡 ENDPOINTS DISPONÍVEIS
📦 Produtos
🔹 Listar produtos
GET /bff/products
🔹 Filtro por categoria
GET /bff/products?categoryId=1
🔹 Com paginação (controlada via SRV)
GET /bff/products?page=0&size=10
🔹 Buscar produto por ID
GET /bff/products/{id}
📂 Categorias
🔹 Listar categorias
GET /bff/categories
🔌 INTEGRAÇÃO COM O SRV

O BFF se comunica com o storeflow-srv via OpenFeign.

Configuração:

storeflow:
  srv:
    url: http://localhost:8080
▶️ COMO RODAR O PROJETO
🔹 Pré-requisitos
Java 21
Maven
SRV rodando na porta 8080
🔹 Rodar via terminal (WSL/Linux)
cd /mnt/c/.../storeflow_bff
chmod +x mvnw
./mvnw clean install
./mvnw spring-boot:run
🔹 Rodar via IDE
Executar a classe:
StoreflowBffApplication
🔹 Porta padrão
http://localhost:8081
🧪 TESTES

Exemplo no Postman:

GET http://localhost:8081/bff/products
GET http://localhost:8081/bff/products/1
GET http://localhost:8081/bff/categories
🔐 SEGURANÇA (ESTADO ATUAL)

Atualmente:

endpoints estão liberados (permitAll)
não há autenticação ativa

Isso foi uma decisão intencional para o MVP.

⚠️ LIMITAÇÕES ATUAIS
resposta de produtos ainda é uma lista simples (List)
não há enriquecimento de dados
não há tratamento avançado de erros
não há autenticação
contrato ainda depende diretamente do SRV
🚀 MELHORIAS FUTURAS — BFF
🔹 Enriquecimento de dados
incluir nome da categoria dentro do produto
evitar necessidade de múltiplas chamadas no frontend
🔹 Tratamento de erro Feign
mapear erros do SRV (404, 400, 500)
transformar em respostas padronizadas
🔹 Logs estruturados
logs com contexto (requestId, endpoint, payload)
facilitar observabilidade
🔹 CORS explícito
configurar acesso do frontend (Angular - porta 4200)
🔹 Autenticação (JWT)
login via BFF
validação de token
proteção de endpoints
🔹 Padronização de resposta

Exemplo futuro:

{
  "data": {...},
  "meta": {...},
  "errors": [...]
}
🔹 Paginação real
suportar objeto de paginação completo
depender do SRV retornar Page estruturado
🚀 MELHORIAS FUTURAS — SRV
🔹 Paginação real com Page
retornar objeto completo (content, totalPages, etc)
evitar uso de lista simples
🔹 Regras de negócio mais robustas
validações de domínio (estoque, preço, etc)
evitar entidade anêmica
🔹 Logs estruturados
rastreamento de requisições
melhor debug em produção
🔹 Tratamento de erro mais detalhado
mensagens mais claras
padronização completa
🔹 Constraints no banco
UNIQUE em category.name
validações mais rígidas
🔹 Testes
unitários (Service)
integração (Controller + DB)
cobertura alta (Sonar)
🔹 Evolução arquitetural
migração para arquitetura hexagonal
uso de Ports & Adapters
🧠 STATUS DO PROJETO
MVP atual
✔ SRV funcional
✔ BFF funcional
🔜 FED (Angular)
🎯 PRÓXIMO PASSO

Iniciar o projeto:

storeflow-fed

com Angular, consumindo os endpoints do BFF.

🧠 RESUMO FINAL

O storeflow-bff representa:

uma camada intermediária real de backend
desacoplamento entre frontend e backend principal
base para evolução com autenticação e microserviços
