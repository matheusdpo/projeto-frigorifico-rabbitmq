package br.com.frigorificos.pedidos.api.v1.dto;

public record PainelDTO(
        String numeroNotaFiscal,
        String pais,
        String unidadeEmitente,
        String horario,
        boolean necessarioLacracao,
        String dataLacracao,
        String horaLacracao,
        String contentor,
        Double temperatura,
        String nroSequencialRelatorioRastrabilidade,
        String nroSequencialRelatorioCarga,
        boolean emiteSigSif,
        String observacoes,
        boolean isCsn,
        String lacreCsn,
        String meioTransporte,
        String sifDestinatario) {

}