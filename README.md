# first-micronaut-app

## GraalVM / native image
```
mn create-app --features file-watch --features graal-native-image products
cd products
mn create-controller Product
./gradlew eclipse
```

```
./gradlew run --continuous
```

```
./build-native-image.sh
```
(`native-image` muss im PATH sein, sonst Befehl entsprechend anpassen.)

## Application
```
curl -v -XPOST -F file=@ch_254900.itf "http://localhost:8080/product"
```



