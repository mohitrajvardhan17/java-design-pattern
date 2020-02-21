package com.design.pattern.builder;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmailBenchmarkTest {

    @State(Scope.Benchmark)
    public static class ExecutionPlan {

        @Param({"100", "200", "300", "500", "1000"})
        public int iterations;

        public class EmailData {
            private String from;
            private String to;
            private String cc;
            private String bcc;
            private String subject;
            private String content;
        }

        List<EmailData> emailDatas = new ArrayList<EmailData>();

        @Setup(Level.Invocation)
        public void setup() {
            for (int i = 0; i < 1000; i++) {
                EmailData emailData = new EmailData();
                emailData.from = UUID.randomUUID().toString() + "@gmail.com";
                emailData.to = UUID.randomUUID().toString() + "@gmail.com";
                emailData.cc = UUID.randomUUID().toString() + "@gmail.com";
                emailData.bcc = UUID.randomUUID().toString() + "@gmail.com";
                emailData.subject = UUID.randomUUID().toString();
                emailData.content = UUID.randomUUID().toString();
                emailDatas.add(emailData);
            }
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.Throughput)
    public void emailBuilder(ExecutionPlan plan) throws InterruptedException {
        for (int i = 0; i < plan.iterations; i++) {
            Email email = Email.EmailBuilder.getInstance()
                    .setFrom(plan.emailDatas.get(i).from)
                    .setTo(plan.emailDatas.get(i).to)
                    .setSubject(plan.emailDatas.get(i).subject)
                    .setContent(plan.emailDatas.get(i).content)
                    .setCC(plan.emailDatas.get(i).cc)
                    .setBCC(plan.emailDatas.get(i).bcc)
                    .build();
        }
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
