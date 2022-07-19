# Build
mvn clean package && docker build -t br.com.validator.password/validator-password .

# RUN

docker rm -f validator-password || true && docker run -d -p 8080:8080 -p 4848:4848 --name validator-password br.com.validator.password/validator-password 