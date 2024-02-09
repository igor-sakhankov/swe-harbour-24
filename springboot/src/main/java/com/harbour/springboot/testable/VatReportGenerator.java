package com.harbour.springboot.testable;

import java.util.List;

public class VatReportGenerator {
    private VatProvider vatProvider;

    public VatReportGenerator(VatProvider vatProvider) {
        this.vatProvider = vatProvider;
    }

    public List<String> generateReport() {
        return List.of("ES: " + vatProvider.getVat() + "%");
    }

    public static void main(String[] args) {
        VatProvider vatProvider = new VatProvider();
        VatReportGenerator vatReportGenerator = new VatReportGenerator(vatProvider);
        System.out.println(vatReportGenerator.generateReport());
    }
}
