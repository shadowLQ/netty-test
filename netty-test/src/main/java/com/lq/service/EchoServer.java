package com.lq.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author LQ
 * @date 2019/04/13 22:27
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port){
        this.port = port;
    }

    public void  start(){
            final  EchoServerHandler serverHandler=new EchoServerHandler();
            EventLoopGroup group=new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap=new ServerBootstrap();

            bootstrap.group(group).channel(NioServerSocketChannel.class)
                                    .localAddress(new InetSocketAddress(port))
                                        .childHandler(new ChannelInitializer<SocketChannel>() {
                                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                                socketChannel.pipeline().addLast(serverHandler);
                                            }
                                        });

            ChannelFuture f=bootstrap.bind().sync();
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                group.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        if (args.length != 1){
//            System.err.println("Usage: " +EchoServer.class.getSimpleName() + " <port> ");
//        }
        //int port=Integer.parseInt(args[0]);
        System.out.println("服务端启动................");
        new EchoServer(9999).start();
    }
}
