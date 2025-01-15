# Contribuindo para este repositório

Obrigado por querer contribuir para este repositório! Para garantir que o processo de desenvolvimento seja eficiente e sem problemas, pedimos que siga as diretrizes abaixo.

## Requisitos de Desenvolvimento

### 1. **Linter**

Este repositório usa **[ESLint](https://eslint.org/)** (ou outro linter configurado) para garantir que o código esteja limpo, consistente e siga as melhores práticas. Antes de enviar qualquer Pull Request (PR), **execute o linter** para verificar o código:

```bash
# Se você ainda não instalou as dependências, execute:
npm install

# Para verificar seu código:
npm run lint
```
Se o linter detectar algum problema, corrija-o antes de continuar. Isso ajuda a garantir que nosso código seja limpo e fácil de manter.

### 2. Branch Principal - develop
Todos os desenvolvedores devem trabalhar na branch develop como a branch principal de desenvolvimento. Ao clonar o repositório, faça checkout da develop:

```bash
git checkout develop
```

### 3. Criação de Branches
Ao iniciar o trabalho em uma nova funcionalidade, correção de bug ou melhoria, sempre crie uma nova branch a partir da develop. Use um nome de branch claro e descritivo, que ajude a identificar o propósito da branch.

Exemplos de convenção de nomenclatura para branches:
- Para novas funcionalidades:
```bash
git checkout -b feature/nome-da-funcionalidade
```
- Para correções de bugs:
```bash
git checkout -b bugfix/nome-do-bug
```
- Para melhorias:
```bash
git checkout -b improvement/nome-da-melhorias
```
- Para tarefas de refatoração:
```bash
git checkout -b refactor/nome-da-refatoracao
```
### 4. Desenvolvimento e Commits
- Commits pequenos e frequentes: Faça commits pequenos e com frequência. Evite fazer um único commit muito grande.
- Mensagens de commit: As mensagens de commit devem ser claras e descritivas. Use o formato a seguir:
  - Tipo de mudança: [tipo] Descrição breve da mudança.
  - Exemplo:
  ```
  feat: Adiciona funcionalidade de login
  bugfix: Corrige erro ao validar dados do formulário
  refactor: Refatora código da função X para melhorar legibilidade
  ```
### 5. Pull Requests (PRs)
- Antes de abrir um PR: Certifique-se de que sua branch está atualizada com a develop. Faça um git pull para garantir que você tem as últimas alterações da branch principal.
- Revisão de código: Sempre que abrir um PR, solicite a revisão de outros membros da equipe para garantir que o código esteja correto e atenda aos padrões do projeto.

### 6. Regras Comuns de Desenvolvimento em Equipe
- Sincronização constante com a develop: Mantenha sua branch atualizada com a branch develop para evitar conflitos durante o merge.
- Testes: Escreva testes para qualquer novo código ou funcionalidade. Se o projeto já inclui testes automatizados, execute-os antes de fazer o merge.
- Respeitar as normas de estilo de código: Utilize o linter e siga as convenções de código acordadas pela equipe. Isso ajuda a manter o código consistente e fácil de entender.
- Comunicação clara: Sempre que necessário, documente seu código e compartilhe informações sobre as decisões de design.
