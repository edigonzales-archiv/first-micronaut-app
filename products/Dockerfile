FROM oracle/graalvm-ce:1.0.0-rc11 as graalvm
COPY . /home/app/products
WORKDIR /home/app/products
RUN ./build-native-image.sh

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/products .
ENTRYPOINT ["./products"]
