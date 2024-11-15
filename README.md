# Gerenciador de Usuários e Tarefas

Este projeto é uma aplicação Java utilizando **Spring Boot**, que faz a relação entre **Usuários** e **Tarefas**. A aplicação implementa o **SOFT delete** para as tarefas, garantindo que os registros sejam marcados como deletados sem serem removidos permanentemente do banco de dados.

## Endpoints da API

### **Usuários**
Gerencia as informações relacionadas aos usuários.

- ```GET /usuarios```  
  Retorna a lista de todos os usuários cadastrados. **Status:** OK.

- ```GET /usuarios/{id}```  
  Retorna os detalhes de um usuário específico pelo seu ID. **Status:** OK.

- ```POST /usuarios```  
  Cadastra um novo usuário. **Status:** OK.

- ```POST /usuarios/{id}```  
  Atualiza as informações de um usuário existente. **Status:** OK.

- ```DELETE /usuarios/{id}```  
  Remove um usuário pelo ID. **Status:** OK.

---

### **Tarefas**
Gerencia as tarefas associadas aos usuários.

- ```GET /tarefas```  
  Retorna a lista de todas as tarefas. **Status:** OK.

- ```GET /tarefas/{id}```  
  Retorna os detalhes de uma tarefa específica pelo ID. **Status:** OK.

- ```GET /tarefas/deleted```  
  Lista todas as tarefas marcadas como deletadas (SOFT delete). **Status:** OK.

- ```GET /tarefas/deleted/user/{usuarioId}```  
  Retorna as tarefas deletadas associadas a um usuário específico. **Status:** OK.

- ```GET /tarefas/pesquisar-titulo?titulo={titulo}```  
  Pesquisa tarefas pelo título. **Status:** OK.

- ```GET /tarefas/pesquisar-data-range?startDate={startDate}&endDate={endDate}```  
  Pesquisa tarefas dentro de um intervalo de datas. **Status:** **VERIFICAR, pois está retornando apenas uma tarefa.**

- ```POST /tarefas```  
  Cadastra uma nova tarefa. **Status:** OK.

- ```DELETE /tarefas/{id}```  
  Realiza o **SOFT delete** de uma tarefa pelo ID, marcando-a como deletada sem removê-la do banco de dados. **Status:** OK.

---

## Observações
- O **SOFT delete** nas tarefas garante que os registros excluídos possam ser restaurados ou consultados no futuro.
- **Correções pendentes:**
  - Verificar o comportamento do endpoint de busca por intervalo de datas: ```GET /tarefas/search-by-date-range``` está retornando apenas uma tarefa.
  - Resolver a atualização de usuários no endpoint ```POST /usuarios/{id}```.

Contribuições e feedbacks são bem-vindos!
