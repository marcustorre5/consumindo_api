package com.example.servico;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.example.dto.EnderecoDto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiServico {

    EnderecoDto enderecoDto = new EnderecoDto();

    public EnderecoDto getEnderecoDto(String cep) throws IOException, InterruptedException {

        try {        
            //criar a requisicao http
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://viacep.com.br/ws/"+cep+"/json/")).build();

            //enviar a requisisao httpp que criamos acima
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            enderecoDto = mapper.readValue(response.body(), EnderecoDto.class);
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return enderecoDto;

    }

}
