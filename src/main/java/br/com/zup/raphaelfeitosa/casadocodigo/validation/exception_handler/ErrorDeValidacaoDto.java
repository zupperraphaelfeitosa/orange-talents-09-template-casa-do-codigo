package br.com.zup.raphaelfeitosa.casadocodigo.validation.exception_handler;

public class ErrorDeValidacaoDto {

    private final String fieldName;
    private final String error;

    public ErrorDeValidacaoDto(String fieldName, String error) {
        this.fieldName = fieldName;
        this.error = error;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getError() {
        return error;
    }
}
