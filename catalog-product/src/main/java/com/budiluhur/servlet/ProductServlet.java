package com.budiluhur.servlet;

import com.budiluhur.model.Product;
import com.budiluhur.repository.ProductRepository;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private ProductRepository productRepository;

    @Override 
    public void init() {
        productRepository = new ProductRepository();

        productRepository.addProduct(new Product( "PRD-001", "Keyboard Mechanical", 450000.0));
        productRepository.addProduct(new Product( "PRD-002", "Mouse Wireless Silent", 175000.0));
        productRepository.addProduct(new Product( "PRD-003", "Monitor Gaming 24 Inch", 2100000.0));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        List<Product> products = productRepository.findAll();

        out.println("<html>");
        out.println("<head><title>Katalog" + " Produk Web</title></head>");
        out.println("<body>");
        out.println("<h2>===Daftar Produk" + "Produk (WEB)===</h2>");
        out.println("<table border='1' cellpadding='8'>");
        out.println("<tr><th>ID Produk</th><th>Nama Produk</th><th>Harga"+ "Satuan</th></tr>");

    for (Product product : products) {
        out.println("<tr>");
        out.println("<td>" + product.getId() + "</td>");
        out.println("<td>" + product.getName() + "</td>");
        out.println("<td>" + product.getPrice() + "</td>");
        out.println("</tr>");
    }
    
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }    
    
}
