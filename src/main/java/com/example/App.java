package com.example;

import com.example.servico.ApiServico;

import java.io.IOException;

import com.example.dto.EnderecoDto;

public class App 
{
    public static void main( String[] args )
    {

        ApiServico apiServico = new ApiServico();

        //printar todos os dados da api:
    //    try {
    //     EnderecoDto enderecoDto = apiServico.getEnderecoDto("37200154");
    //     System.out.println(enderecoDto);
    //    } catch ( Exception e )
    //    {
    //        System.out.println(e.getMessage());
    //    }

        //printar somente o logradouro:
        try {

            //printar somente o logradouro:
            EnderecoDto enderecoDto =  apiServico.getEnderecoDto("37200154");
            System.out.println(enderecoDto.getLogradouro());

            //printar todo o conteudo:
            //System.out.println(apiServico.getEnderecoDto("37207500"));
        } catch (IOException e) {
            throw new RuntimeException(e);
            
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }	

    }
}       
