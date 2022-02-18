package com.example.excelapi.excel.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoZona {

    private Integer filaInicial;
    private Integer filaFinal;
    private Integer columnaInicial;
    private Integer columnaFinal;


}
