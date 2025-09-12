import 'package:flutter/material.dart';

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
                Container(
                  height: MediaQuery.of(context).size.height/3,
                  width: MediaQuery.of(context).size.width,
                  child: Row(
                    children: [
                      ListTile(
                        title: Text("data"),
                      ),
                      ListTile(
                        title: Text("data"),
                      ),
                      ListTile(
                        title: Text("data"),
                      )
                    ],
                  ),
                )
              ],
            ),
          ),
          Container(
            color: Colors.lightBlueAccent.shade100,
          )
        ],
      )
    );
  }
}
