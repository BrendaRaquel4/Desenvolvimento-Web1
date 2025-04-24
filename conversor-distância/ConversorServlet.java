package com.ufscar.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/converter")
public class ConversorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opcao = request.getParameter("opcao");
        String valorStr = request.getParameter("valor");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Conversor de Distância</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 20px; background: #f5f5f5; }");
        out.println(".caixa { max-width: 500px; margin: 20px auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }");
        out.println("h1 { color: #2c3e50; text-align: center; margin-top: 0; }");
        out.println(".resultado { background: #f8f9fa; border: 1px solid #e0e0e0; border-radius: 4px; padding: 15px; margin: 20px 0; text-align: letf; }");
        out.println(".voltar { display: block; text-align: left; color: #2196F3; margin-top: 20px; text-decoration: none; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='caixa'>");
        out.println("<h1>Conversor de Distância</h1>");
        
        if (opcao == null || valorStr == null || !valorStr.matches("-?\\d+")) {
            out.println("<div class='resultado' style='color:#000000;'>");
            out.println("<p> Erro</p>");
            out.println("<p>(a) A entrada deve ter apenas valores inteiros</p>");
            out.println("<p>(b) A opção de conversão é inválida</p>");
            out.println("</div>");
        } else {
            try {
                int valor = Integer.parseInt(valorStr);
                out.println("<div class='resultado'>");
                out.println("<p>" + formatarResultado(opcao, valor) + "</p>");
                out.println("</div>");
            } catch (NumberFormatException e) {
                out.println("<div class='resultado' style='color:#d32f2f;'>");
                out.println("<p>Erro: Digite apenas números inteiros</p>");
                out.println("</div>");
            }
        }
        
        out.println("<a href='index.html' class='voltar'>Retorne à página principal</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    private String formatarResultado(String opcao, int valor) {
        switch (opcao) {
            case "miParaM":
                return String.format("%.2f milhas equivalem a %.2f metros", (double)valor, valor * 1609.34);
            case "mParaMi":
                return String.format("%.2f metros equivalem a %.2f milhas", (double)valor, valor / 1609.34);
            case "ftParaM":
                return String.format("%.2f pés equivalem a %.2f metros", (double)valor, valor * 0.3048);
            case "mParaFt":
                return String.format("%.2f metros equivalem a %.2f pés", (double)valor, valor / 0.3048);
            default:
                return "Opção de conversão inválida";
        }
    }
}
