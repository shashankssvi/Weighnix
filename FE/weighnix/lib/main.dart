import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});


  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  void initState() {
    super.initState();
    // getdata();
    connector("connect");
    receive();
  }

  @override
  void dispose() {
    controller.dispose();
    connector("disconnect");
    super.dispose();
  }


  var data1 = 0.0;

  var name ="";



  var channel = MethodChannel("com.example.bluet/blue");

  connector(String a)async{
    await channel.invokeMethod(a,{"value":controller.text});
  }


  TextEditingController controller = TextEditingController(text: "12");

  receive()async{
    var data = await channel.invokeMethod("receive");
    setState(() {
      data1 = double.parse(data);
    });
    return data1;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.black,
          title: Center(child: Text("SYS SYSTEM",style: TextStyle(color: Colors.white),textAlign: TextAlign.center,)),
        ),
        body: Column(
          children: [
            Container(
              color: Colors.black,
              child: Column(
                mainAxisSize: MainAxisSize.max,
                children: [
                  Card(
                    color: Colors.lightBlueAccent.shade100,
                    child: ListTile(
                      title: Text("Hello User,",style: TextStyle(color: Colors.black,fontWeight: FontWeight.bold,fontSize: 24),),
                      subtitle: Text("Welcome back!",style: TextStyle(color: Colors.black,fontSize: 18),),
                    ),
                  ),
                  Card(
                    color: Colors.black,
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      crossAxisAlignment: CrossAxisAlignment.center,
                      children: [
                        Expanded(
                          child: Card(
                            child: Padding(
                              padding: const EdgeInsets.all(8.0),
                              child: Text.rich(
                                  textAlign: TextAlign.center,
                                  TextSpan(children: [
                                    TextSpan(text:"GAS STATUS\n",style: TextStyle(color: Colors.black45,fontSize: 18)),
                                    TextSpan(text: "100 %"),
                                  ])
                              ),
                            ),
                          ),
                        ),

                        Expanded(
                          child: Card(
                            child: Padding(
                              padding: const EdgeInsets.all(8.0),
                              child: Text.rich(
                                  textAlign: TextAlign.center,
                                  TextSpan(children: [
                                    TextSpan(text:"FUEL AUTONOMY\n",style: TextStyle(color: Colors.black45,fontSize: 18)),
                                    TextSpan(text: "44 DAYS*"),
                                  ])
                              ),
                            ),
                          ),
                        ),
                        Expanded(
                          child: Card(
                            child: Padding(
                              padding: const EdgeInsets.all(8.0),
                              child: Text.rich(
                                  textAlign: TextAlign.center,
                                  TextSpan(children: [
                                    TextSpan(text:"AVERAGE USAGE\n",style: TextStyle(color: Colors.black45,fontSize: 18)),
                                    TextSpan(text: "0.2% PER DAY"),
                                  ])
                              ),
                            ),
                          ),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),
            FutureBuilder(future: receive(), builder: (context,snapshot){
              if(snapshot.hasData){
                return Text("${data1}");
              }
              else{
                return Text("");
              }
            }),
            Container(
              color: Colors.lightBlueAccent,
              width: MediaQuery.of(context).size.width,
              child: Column(
                mainAxisSize: MainAxisSize.max,
                children: [
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Text("GAS LEVEL",style: TextStyle(fontSize: 30,fontWeight: FontWeight.bold),),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Container(
                      decoration: BoxDecoration(
                          color: data1>=10.0?Colors.greenAccent:Colors.redAccent,
                          borderRadius: BorderRadius.circular(12),
                          border: Border.all(color: Colors.black,width: 5)
                      ),
                      width: MediaQuery.of(context).size.width/2.5,
                      height: 250,
                      child: Center(child: Text("${data1}")),
                    ),
                  )
                ],
              ),
            ),

          ],
        ),
      floatingActionButton: FloatingActionButton(onPressed: (){
        connector("connect");
        receive();
      },child: Icon(Icons.refresh),),
    );
  }
}
