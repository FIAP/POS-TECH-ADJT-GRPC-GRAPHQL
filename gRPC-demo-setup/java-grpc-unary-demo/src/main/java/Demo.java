public class Demo {
    public static void main(String[] args) {

        GrpcServer.create(6565, builder -> {
                    builder.addService(new VeiculoService());
                })
                .start()
                .await();

    }
}
