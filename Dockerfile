#Sistema operaciona + a linguagem de programação da imagem
FROM eclipse-temurin:17-jdk-jammy

#area de trabalho da maquina virtual do docker
WORKDIR /app

#compiando os arquivos do meu programa para a maquina virtual
COPY .mvn/ .mvn
#compiando os arquivos "mvnw" e "pom.xml" do meu programa para a maquina virtual
COPY mvnw pom.xml ./

#transforma mvnw em executavel, comando linux
RUN chmod +x mvnw

# executando o maven resolvendo as dependencias do programa
RUN ./mvnw dependency:resolve

#copiando os arquivos do src para dentro da maquina virtual/container
COPY src ./src

#comando de execução da máquina virtual/container
CMD ["./mvnw", "spring-boot:run"]