# Etapa 1: Definir a imagem base (imagens do Node.js)
FROM node:22

# Etapa 2: Definir o diretório de trabalho no container
WORKDIR /app

# Etapa 3: Copiar o package.json e o package-lock.json para o container
COPY package*.json ./

# Etapa 4: Instalar as dependências do projeto
RUN npm install

# Etapa 5: Copiar o resto dos arquivos para o container
COPY . .

# Etapa 6: Expor a porta em que o React vai rodar (geralmente 3000)
EXPOSE 3000

# Etapa 7: Rodar o comando para iniciar o app
CMD ["npm", "start"]
