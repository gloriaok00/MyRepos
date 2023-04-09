package com.example.demo.mm.thread.manyget3;

/**
 *  @description 多个服务返回的思路
 *  @date  2023/4/9 13:40
 */
public class HttpApiA {

   /* private final UserServiceGrpc.UserServiceStub userStub;
    private final ProductServiceGrpc.ProductServiceStub productStub;
    private final MerchantServiceGrpc.MerchantServiceStub merchantStub;

    public HttpApiA() {
        // 创建用户、商品、商户服务的gRPC Stub
        ManagedChannel userChannel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        userStub = UserServiceGrpc.newStub(userChannel);

        ManagedChannel productChannel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();
        productStub = ProductServiceGrpc.newStub(productChannel);

        ManagedChannel merchantChannel = ManagedChannelBuilder.forAddress("localhost", 50053)
                .usePlaintext()
                .build();
        merchantStub = MerchantServiceGrpc.newStub(merchantChannel);
    }

    public HttpApiResponse getInfo() {
        // 使用CountDownLatch等待三个服务的响应
        CountDownLatch latch = new CountDownLatch(3);

        // 用于存储三个服务的响应结果
        UserInfoResponse userResponse = null;
        ProductInfoResponse productResponse = null;
        MerchantInfoResponse merchantResponse = null;

        // 用于执行并发请求的线程池
        ExecutorService executor = Executors.newCachedThreadPool();

        // 获取用户信息
        executor.submit(() -> {
            userStub.getUserInfo(UserInfoRequest.newBuilder().setUserId(123).build(), new StreamObserver<UserInfoResponse>() {
                @Override
                public void onNext(UserInfoResponse response) {
                    userResponse = response;
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("Failed to get user info: " + t.getMessage());
                    latch.countDown();
                }

                @Override
                public void onCompleted() {
                    latch.countDown();
                }
            });
        });

        // 获取商品信息
        executor.submit(() -> {
            productStub.getProductInfo(ProductInfoRequest.newBuilder().setProductId(456).build(), new StreamObserver<ProductInfoResponse>() {
                @Override
                public void onNext(ProductInfoResponse response) {
                    productResponse = response;
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("Failed to get product info: " + t.getMessage());
                    latch.countDown();
                }

                @Override
                public void onCompleted() {
                    latch.countDown();
                }
            });
        });

        // 获取商户信息
        executor.submit(() -> {
            merchantStub.getMerchantInfo(MerchantInfoRequest.newBuilder().setMerchantId(789).build(), new StreamObserver<MerchantInfoResponse>() {
                @Override
                public void onNext(MerchantInfoResponse response) {
                    merchantResponse = response;
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("Failed to get merchant info: " + t.getMessage());
                    latch.countDown();
                }

                @Override
                public void onCompleted() {
                    latch.countDown();
                }
            });
        });

        // 等待三个服务的响应
        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for responses: " + e.getMessage());
        }
        // 组合三个服务的响应结果并返回
        HttpApiResponse response = new HttpApiResponse();
        response.setUserInfo(userResponse);
        response.setProductInfo(productResponse);
        response.setMerchantInfo(merchantResponse);
        return response;
    }

    public static void main(String[] args) throws IOException {
        HttpApiA httpApiA = new HttpApiA();
        HttpApiResponse response = httpApiA.getInfo();
        System.out.println(response);
    }*/
}
