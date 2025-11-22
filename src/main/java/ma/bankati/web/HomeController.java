package ma.bankati.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.bankati.config.NativeApplicationContext;
import ma.bankati.service.IMoneyService;

import java.io.IOException;

@WebServlet(urlPatterns = "/home", loadOnStartup = 1)
public class HomeController extends HttpServlet
{
    private IMoneyService service;

    public HomeController()
    {
        System.out.println("Call for HomeController Constructor");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Call for HomeController init Method");
        service = NativeApplicationContext.getBean(IMoneyService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                                throws ServletException, IOException {


        System.out.println("Call for HomeController doGet Method");


        response.setContentType("text/html");
        String view =
                """
                        <html>
                        <body style="font-family:Optima">
                            
                        		<h1>Bienvenue à Votre compte Bankati ^_^</h1>
                        		<h2>
                        		    <ul style="color:blue">
                        		        <li>Solde de votre compte  :   %s</li>
                        		    </ul>
                        		</h2>
                        </body>
                        </html>
                        
                """;
        var solde = service.convertData();
        var out = response.getWriter();
        out.println(String.format(view,solde));


    }

    @Override
    public void destroy() {
        System.out.println("Call for HomeController destroy method");
    }
}
