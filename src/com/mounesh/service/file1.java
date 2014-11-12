package com.mounesh.service;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
/**
 * Servlet implementation class file
 */
///@WebServlet("/file")
public class file1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;

    public void init() throws ServletException{
        getServletContext().setAttribute("test", "E:\\Local");
        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
        fileFactory.setRepository(filesDir);
        
        this.uploader = new ServletFileUpload(fileFactory);
        
    }  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public file1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
	       // PrintWriter out = response.getWriter();
	        String fileName = request.getParameter("fileName");
	        if(fileName == null || fileName.equals("")){
	            throw new ServletException("File Name can't be null or empty");
	        }
	        File file = new File(request.getServletContext().getAttribute("test")+File.separator+fileName);
	        if(!file.exists()){
	            throw new ServletException("File doesn't exists on server.");
	        }
	        System.out.println("File location on server::"+file.getAbsolutePath());
	        ServletContext ctx = getServletContext();
	        InputStream fis = new FileInputStream(file);
	        System.out.println(fis);
	        String mimeType = ctx.getMimeType(file.getAbsolutePath());
	        System.out.println(mimeType);
	        response.setContentType(mimeType != null? mimeType:"application/octet-stream");
	        response.setContentLength((int) file.length());
	        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	        ServletOutputStream os = response.getOutputStream();
	        byte[] bufferData = new byte[1024];
	        int read=0;
	        System.out.println("writing");
	        System.out.println("");
	        while((read = fis.read(bufferData))!= -1){
	            System.out.println(read);
	            os.write(bufferData, 0, read);
	           
	        }
	        os.flush();
	        os.close();
	        fis.close();
	        
	        System.out.println("File downloaded at client successfully");

	        try {
	            /* TODO output your page here
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Servlet UploadDownloadFileServlet</title>");  
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h1>Servlet UploadDownloadFileServlet at " + request.getContextPath () + "</h1>");
	            out.println("</body>");
	            out.println("</html>");
	             */
	        } finally {            
	           //out.close();
	        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
			 System.out.println("Before Uploading the file");
			processRequest1(request, response);
			System.out.println("ProcessRequest1 has called");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processRequest1(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, FileUploadException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
       
        if(!ServletFileUpload.isMultipartContent(request)){
            throw new ServletException("Content type is not multipart/form-data");
        }out.write("<html><head></head><body>");

        try {
        	System.out.println("parse Request");
          //  @SuppressWarnings("unchecked")
            HashMap<String, List<FileItem>> fileItemsList =  (HashMap<String, List<FileItem>>)uploader.parseParameterMap(request);
            //System.out.println(fileItemsList.get("name"));
            System.out.println(fileItemsList.get("file"));
            //String fileItem="";
            
            FileItem fileItem = fileItemsList.get("file").get(0);
      
            System.out.println("fileItem="+fileItem);
            System.out.println("FieldName="+fileItem.getFieldName());
            System.out.println("FileName="+fileItem.getName());
            System.out.println("ContentType="+fileItem.getContentType());
            System.out.println("Size in bytes="+fileItem.getSize());
            File file = new File(request.getServletContext().getAttribute("test")+File.separator+fileItem.getName());
            System.out.println("Absolute Path at server="+file.getAbsolutePath());
            fileItem.write(file);
            out.write("File "+fileItem.getName()+ " uploaded successfully.");
            /* To go back to Home Page*/
            RequestDispatcher rd=request.getRequestDispatcher("/homePage.html");  
            rd.include(request, response);
            //fileT
			//List<FileItem> fileItemsList = (List<FileItem>) uploader.parseParameterMap(request);
            System.out.println("after parse Request");
            /*Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
            while(fileItemsIterator.hasNext()){
                FileItem fileItem = fileItemsIterator.next();
                System.out.println("fileItem="+fileItem);
                System.out.println("FieldName="+fileItem.getFieldName());
                System.out.println("FileName="+fileItem.getName());
                System.out.println("ContentType="+fileItem.getContentType());
                System.out.println("Size in bytes="+fileItem.getSize());
                File file = new File(request.getServletContext().getAttribute("test")+File.separator+fileItem.getName());
                System.out.println("Absolute Path at server="+file.getAbsolutePath());
                
                out.write("File "+fileItem.getName()+ " uploaded successfully.");
                out.write("<br>");
                out.write("<a href=\"file?fileName="+fileItem.getName()+"\">Download "+fileItem.getName()+"</a>");*/
            }
        /*}
	catch (FileUploadException e) {
        	e.printStackTrace();
            out.write("Exception in uploading file1...");
        } catch (Exception e) {
            out.write("Exception in uploading file2...");
            e.printStackTrace();
        out.write("</body></html>");
    }
*/

	
	catch(Exception e)
	{
		e.printStackTrace();
	}
        
        
        
        try {
        	/* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadDownloadFileServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadDownloadFileServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
             
        } finally {            
            out.close();
        }
		
	}

}
