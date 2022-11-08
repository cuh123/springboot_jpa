package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.example.demo.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;



public class TestApplication {
  public static void main (String [] args) {
    //////////나의 스트림 공부장
/*    List<String> list = new ArrayList<>();
    list.add("민수");
    list.add("미선");
    list.add("성식");
    
    Stream<String> stream = list.stream();
    Stream<String> parallelStream = list.parallelStream();
    
    Stream<String> builderStream = Stream.<String>builder()
                                          .add("Eric").add("Elena").add("Java")
                                          .build();
    
    Stream<String> generatedStream = Stream.generate(()-> "gen").limit(5);
    
    Stream<String> stream1 = Stream.of("Java", "Scala", "Groovy");
    Stream<String> stream2 = Stream.of("Python", "Go", "Swift");
    Stream<String> concat = Stream.concat(stream1, stream2);
    List<String> concatList = concat.collect(Collectors.toList());
//    for (String s: concatList) {
//      System.out.println(s);
//    }
    
    Stream<String> stream3 = Stream.of("Java", "Scala", "Groovy");
    Stream<String> stream4 = Stream.of("Python", "Go", "Swift");
    Stream<String> concat1 = Stream.concat(stream3, stream4);
    Set<String> concatHashSet= concat1.collect(Collectors.toSet());
//    for(String s : concatHashSet) {
//      System.out.println(s);
//    }
    
    Stream<String> fruits = Stream.of("banana", "apple", "mango", "kiwi", "peach", "cherry", "lemon");
    Function<String, Integer> getCount = fruit-> fruit.length();
    Optional<String> result = fruits.map(Object::toString).collect(maxBy(comparing(getCount)));
    System.out.println("result: " + result.orElse("no Item"));
   
    System.out.println("##################################################################");
    List<String> list01 = Arrays.asList("a1", "a2", "b1", "b2", "c2", "c1", "c3");
    Stream<String> stream01 = list01.stream();
    Stream<String> filtered = stream01.filter(s -> s.startsWith("c"));
    filtered.forEach(System.out::println);
    
    System.out.println("#################################################################");
    List<String> list02 =
        Arrays.asList("a1", "a2", "b1", "b2", "c2", "c1", "c3");
    Stream<String> stream02 = list02.stream();
//    stream02.map(s -> s.toUpperCase()).forEach(System.out::println);
    stream02.map(String::toUpperCase).forEach(System.out::println);
    System.out.println("#################################################################");
    
    
    //Stream 생성법 여러개
   // from Array
//    String[] arr = new String[]{"a","b","c"};
//    Stream<String> stream = Arrays.stream(arr);

    // from Collection
//    List<String> lists = Arrays.asList("a", "b", "c");
//    Stream<String> stream = lists.stream();

    // only Stream Class
//    Strean<String> stream = Stream.of("a", "b", "c"); 
    
    //이제 실전 연습 가즈아 XML_STRING
  String XML_STRING = null;
  String prettyJson = null;
   Path xmlPath = Paths.get("D://download//enuriSample.xml");
    try {
      XML_STRING = Files.lines(xmlPath).collect(Collectors.joining("\n"));
      System.out.println("##############################################################");
      Files.lines(xmlPath).filter(id -> id.startsWith("<id>"))
            .forEach(System.out::println);
//      Files.lines(xmlPath).filter(id -> id.startsWith("<id>")).filter(id -> id.endsWith("</id>"))
//            .collect(Collectors.toList()) .forEach(System.out::println);
      System.out.println("##############################################################");
      // 맨앞 맨뒤 <good> </good> 삭제
      XML_STRING = XML_STRING.substring(XML_STRING.indexOf("<good>")+6, XML_STRING.indexOf("</good>"));
//      System.out.println("##################################################################");
//      System.out.println(XML_STRING);
//      System.out.println("##################################################################");
    } catch (IOException e) {}

    JSONObject XMLtoJSON = XML.toJSONObject(XML_STRING);
    
    System.out.println(XMLtoJSON);
    */
    // XML 문서 파싱
//    try {
//      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//      DocumentBuilder documentBuilder = factory.newDocumentBuilder();
//      Document document = documentBuilder.parse("D://download//test.xml");
//      Element root = document.getDocumentElement();
//      System.out.println("class name : "+root.getAttribute("name"));
//      NodeList childeren = root.getChildNodes(); // 자식 노드 목록 get
//      for(int i = 0; i < childeren.getLength(); i++){
//          Node node = childeren.item(i);
//          if(node.getNodeType() == Node.ELEMENT_NODE){ // 해당 노드의 종류 판정(Element일 때)
//              Element ele = (Element)node;
//              String nodeName = ele.getNodeName();
//              System.out.println("node name: " + nodeName);
//              if(nodeName.equals("teacher")){
//                  System.out.println("node attribute: " + ele.getAttribute("name"));
//              }
//              else if(nodeName.equals("student")){
//                  // 이름이 student인 노드는 자식노드가 더 존재함
//                  NodeList childeren2 = ele.getChildNodes();
//                  for(int a = 0; a < childeren2.getLength(); a++){
//                      Node node2 = childeren2.item(a);
//                      if(node2.getNodeType() == Node.ELEMENT_NODE){
//                          Element ele2 = (Element)node2;
//                          String nodeName2 = ele2.getNodeName();
//                          System.out.println("node name2: " + nodeName2);
//                          System.out.println("node attribute2: " + ele2.getAttribute("num"));
//                      }
//                  }
//              }
//          }
//      }
//    }catch(Exception ex){
//      System.out.println(ex);
//    }
    
    
    //// 파일 읽고 이쁜 제이슨으로 보여주기
//   String XML_STRING = null;
//    String prettyJson = null;
//    Path xmlPath = Paths.get("D://download//enuriSample.xml");
//    try {
//      XML_STRING = Files.lines(xmlPath).collect(Collectors.joining("\n"));
//
//      // 맨앞 맨뒤 <good> </good> 삭제
//      // XML_STRING = XML_STRING.substring(XML_STRING.indexOf("<good>")+6,
//      // XML_STRING.indexOf("</good>"));
//      System.out.println("##################################################################");
//      System.out.println(XML_STRING);
//      System.out.println("##################################################################");
//    } catch (IOException e) {}
//
//    JSONObject XMLtoJSON = XML.toJSONObject(XML_STRING);
//
//    // 제이슨 형식 이쁘게 만들어서 출력
//    ObjectMapper mapper = new ObjectMapper();
//    try {
//      Object jsonObject = mapper.readValue(XMLtoJSON.toString(), Object.class);
//      prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
//      System.out.println(prettyJson);
//      System.out.println("##################################################################");
//    } catch (IOException e) {
//      e.printStackTrace();
//    }   
    
 // JSON array string
 // [{"name":"mkyong", "age":37}, {"name":"fong", "age":38}]
   try {
     
     ObjectMapper mapper = new ObjectMapper();
     String json = "[{\"name\":\"mkyong\", \"age\":37}, {\"name\":\"fong\", \"age\":38}]";

     // 1. convert JSON array to Array objects
     Person[] pp1 = mapper.readValue(json, Person[].class);

     // 2. convert JSON array to List of objects
     List<Person> ppl2 = Arrays.asList(mapper.readValue(json, Person[].class));

     
     Stream<Person> stream = ppl2.stream();
     stream.forEach(System.out::println);
   }catch(Exception ex) {
    ex.getStackTrace();
   }
  }
}