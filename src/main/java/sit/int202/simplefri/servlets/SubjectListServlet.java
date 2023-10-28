package sit.int202.simplefri.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.simplefri.entities.Subject;
import sit.int202.simplefri.repositories.SubjectRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SubjectListServlet", value = "/subject-list")
public class SubjectListServlet extends HttpServlet {
    private long startTime;

    @Override
    public void init() throws ServletException {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void destroy() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Duration of SubjectListServlet is " +
                (System.currentTimeMillis()-startTime) + " milli seconds");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SubjectRepository subjectRepository = new SubjectRepository();
        List<Subject> subjects = subjectRepository.findAll();
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("/subject_list.jsp").forward(request,response);

//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>Subject List::</h1><hr>");
//        for (Subject subject : subjectRepository.findAll()) {
//            out.println(subject.getId());
//            out.println(" ");
//            out.println(subject.getTitle());
//            out.println("Credit : ");
//            out.println(subject.getCredit());
//            out.println("</br>");
//        }
//        out.println("</hr>");
//        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
