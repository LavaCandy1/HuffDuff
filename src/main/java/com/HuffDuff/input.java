package com.HuffDuff;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.http.*;

public class input extends HttpServlet
{
	ArrayList<String> list1;
	public void pathListOut(ArrayList<String> l1) {
		this.list1 = l1;
		System.out.println(list1);
	}
	
	
	
	
	
	
	
	
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	{
		String block = req.getParameter("awesomeness");
		String roomType = req.getParameter("Room_Type");
		String classCode= req.getParameter("class_code");
		String roomCode = classCode+block+roomType;
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		classCoordinateFinder obj1 = new classCoordinateFinder();
		String finalPath = obj1.classCoordinateFinder1(roomCode);
		System.out.println(finalPath);
		
		
		
		
		
		
		
		pw.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"UTF-8\" />\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
				+ "    <link href=\"outty.css\" rel=\"stylesheet\" />\r\n"
				+ "    <title>Output</title>\r\n"
				+ "  </head>\r\n"
				+ "  <body onload=\"setupCanvas()\">\r\n"
				+ "    <div class=\"border\">\r\n"
				+ "    <div class=\"card\">\r\n"
				+ "\r\n"
				+ "      <header>\r\n"
				+ "\r\n"
				+ "      <div class=\"card_body\">\r\n"
				+ "        <aside>\r\n"
				+ "          <span id=\"title\">HuffDuff</span>\r\n"
				+ "          <div class=\"tileset-container\">\r\n"
				+ "            <img id=\"tileset-source\" crossorigin />\r\n"
				+ "              <span id=\"legend\">Shortest Path</span>\r\n"
				+ "              <span id=\"legend2\">Starting Position</span>\r\n"
				+ "              <span id=\"legend3\">Final Position</span>\r\n"
				+ "            <div class=\"tileset-container_selection\"></div>\r\n"
				+ "            <img src=\"Images\\Group 2.png\" id=\"divider\">\r\n"
				+ "            <button id=\"trial\"></button>\r\n"
				+ "            <button id=\"trial2\"></button>\r\n"
				+ "          </div>\r\n"
				+ "        </aside>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "        <div class=\"card_right-column\">\r\n"
				+ "          <canvas\r\n"
				+ "            width=\"1295\"\r\n"
				+ "            height=\"535\"\r\n"
				+ "            id=\"canvas\"\r\n"
				+ "            style=\"background-size: 1295px 535px\"\r\n"
				+ "          >\r\n"
				+ "          </canvas>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "  </div>\r\n"
				+ "    <script>\r\n"
				+ "      var canvas = document.querySelector(\"canvas\");\r\n"
				+ "      var tilesetContainer = document.querySelector(\".tileset-container\");\r\n"
				+ "      var tilesetSelection = document.querySelector(\r\n"
				+ "        \".tileset-container_selection\"\r\n"
				+ "      );\r\n"
				+ "      var tilesetImage = document.querySelector(\"#tileset-source\");\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "      var isMouseDown = false;\r\n"
				+ "      var currentLayer = 0;\r\n"
				+ "      var layers = [\r\n"
				+ "        {\r\n"
				+ "\r\n"
				+ "        },\r\n"
				+ "\r\n"
				+ "        {},\r\n"
				+ "\r\n"
				+ "        {},\r\n"
				+ "      ];\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "      tilesetContainer.addEventListener(\"mousedown\", (event) => {\r\n"
				+ "        selection = getCoords(event);\r\n"
				+ "        tilesetSelection.style.left = selection[0] * 39 + \"px\";\r\n"
				+ "        tilesetSelection.style.top = selection[1] * 41 + \"px\";\r\n"
				+ "      });\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "      function addTile(mouseEvent) {\r\n"
				+ "        var clicked = getCoords(event);\r\n"
				+ "        var key = clicked[0] + \"-\" + clicked[1];\r\n"
				+ "\r\n"
				+ "        if (mouseEvent.shiftKey) {\r\n"
				+ "          delete layers[currentLayer][key];\r\n"
				+ "        } else {\r\n"
				+ "          layers[currentLayer][key] = [selection[0], selection[1]];\r\n"
				+ "        }\r\n"
				+ "        draw();\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "      \r\n"
				+ "\r\n"
				+ "      function getCoords(e) {\r\n"
				+ "        const { x, y } = e.target.getBoundingClientRect();\r\n"
				+ "        const mouseX = e.clientX - x;\r\n"
				+ "        const mouseY = e.clientY - y;\r\n"
				+ "        return [Math.floor(mouseX / 41), Math.floor(mouseY / 41)];\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "      function exportImage() {\r\n"
				+ "        var data = canvas.toDataURL();\r\n"
				+ "        var image = new Image();\r\n"
				+ "        image.src = data;\r\n"
				+ "\r\n"
				+ "        var w = window.open(\"\");\r\n"
				+ "        w.document.write(image.outerHTML);\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "      function clearCanvas() {\r\n"
				+ "        layers = [{}, {}, {}];\r\n"
				+ "        draw();\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      function setLayer(newLayer) {\r\n"
				+ " \r\n"
				+ "        currentLayer = newLayer;\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "        var oldActiveLayer = document.querySelector(\".layer.active\");\r\n"
				+ "        if (oldActiveLayer) {\r\n"
				+ "          oldActiveLayer.classList.remove(\"active\");\r\n"
				+ "        }\r\n"
				+ "        document\r\n"
				+ "          .querySelector(`[tile-layer=\"${currentLayer}\"]`)\r\n"
				+ "          .classList.add(\"active\");\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      function draw() {\r\n"
				+ "        var ctx = canvas.getContext(\"2d\");\r\n"
				+ "        ctx.clearRect(0, 0, canvas.width, canvas.height);\r\n"
				+ "\r\n"
				+ "        var size_of_crop = 41;\r\n"
				+ "\r\n"
				+ "        layers.forEach((layer) => {\r\n"
				+ "          Object.keys(layer).forEach((key) => {\r\n"
				+ "            var positionX = Number(key.split(\"-\")[0]);\r\n"
				+ "            var positionY = Number(key.split(\"-\")[1]);\r\n"
				+ "            var [tilesheetX, tilesheetY] = layer[key];\r\n"
				+ "\r\n"
				+ "            ctx.drawImage(\r\n"
				+ "              tilesetImage,\r\n"
				+ "              tilesheetX * 39,\r\n"
				+ "              tilesheetY * 41,\r\n"
				+ "              size_of_crop,\r\n"
				+ "              size_of_crop,\r\n"
				+ "              positionX * 39,\r\n"
				+ "              positionY * 41,\r\n"
				+ "              size_of_crop,\r\n"
				+ "              size_of_crop\r\n"
				+ "            );\r\n"
				+ "          });\r\n"
				+ "        });\r\n"
				+ "      }\r\n"
				+ "\r\n"
				+ "      //Structure is \"x-y\": [\"tileset_x\", \"tileset_y\"]\r\n"
				+ "          //EXAMPLE: \"1-1\": [3, 4],");
		
		
		
			pw.printf("var defaultState = [{%s}];",finalPath);
		pw.println("tilesetImage.onload = function () {\r\n"
				+ "        layers = defaultState;\r\n"
				+ "        draw();\r\n"
				+ "        setLayer(0);\r\n"
				+ "      };\r\n"
				+ "      tilesetImage.src =\r\n"
				+ "      \"https://i.postimg.cc/kg7PZShx/tile-Final.png\";\r\n"
				+ "    </script>\r\n"
				+ "  </body>\r\n"
				+ "</html>");

	}
}