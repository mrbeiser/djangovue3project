<script>
import axios from "axios";
export default {
  name: 'App',
  data(){
    return{

      allTasks: [],
      pickedItem: [],
      addTask: [{}],
      newTask: false,
      filterByStatus: 3,
      uncompletedArray: [],
      shownArray: [],
      completedArray: [],
      orderBy: "asc"
    };
  },
  methods: {
    getAll() {
      axios.get("http://localhost:8080/api/tasks/showAll")
          .then((response)=> this.allTasks=response.data);
    },
    getShown() {
      axios.get("http://localhost:8080/api/tasks/showAll")
          .then((response)=> this.shownArray=response.data);
    },
    pickItem(task){
      this.pickedItem = [];
      this.pickedItem.push(task)
    },
    updateTask(pickedTask){
      axios.put("http://localhost:8080/api/tasks/updateTask/"+pickedTask.taskID,
          {
            taskID: pickedTask.taskID,
            taskTitle: pickedTask.taskTitle,
            taskDescription: pickedTask.taskDescription,
            taskIsDone: pickedTask.taskIsDone,
            taskDaysLeft: pickedTask.taskDaysLeft
          }
      )
          .then((response) => console.log(response));
      location.reload()

    },
    updateIsDone(task){
      axios.put("http://localhost:8080/api/tasks/changeIsDone/"+task.taskID, {
        taskIsDone: task.taskIsDone
      })
          .then((response) => console.log(response))
    },
    sendNewTask(addTasks){

      if(addTasks.taskTitle !== null && addTasks.taskDescription !== null && addTasks.taskDaysLeft >0 ){
        axios.post("http://localhost:8080/api/tasks/save", addTasks)
            .then((response) => console.log(response));
        location.reload()
      }
      else {
        this.newTask = false;
        location.reload();
      }
    },
    deleteItem(task){
      axios.delete("http://localhost:8080/api/tasks/deleteTask/"+task.taskID);
      location.reload()
    },
    filterByDone(){
      this.completedArray =[];
      this.uncompletedArray=[];
      if(parseInt(this.filterByStatus)=== 2){

        let i=0;
        for(i = 0; i < this.allTasks.length; i++){
          if(this.allTasks[i].taskIsDone){
            console.log("loh")

          }
          else {
            this.uncompletedArray.push(this.allTasks[i]);
          }



        }


        console.log(this.uncompletedArray)
        this.shownArray = [];
        this.shownArray = [].concat(this.uncompletedArray)

      }
      if(parseInt(this.filterByStatus)=== 1){

        let f=0;
        for(f = 0; f < this.allTasks.length; f++){
          if(this.allTasks[f].taskIsDone){
            this.completedArray.push(this.allTasks[f]);

          }
          else {
            console.log("loh")
          }



        }


        console.log(this.uncompletedArray)

        this.shownArray = [].concat(this.completedArray)

      }

      if(parseInt(this.filterByStatus)=== 3){


        this.shownArray = [].concat(this.allTasks)

      }
      },



    orderArray(){
        if(this.orderBy==="asc"){

          this.shownArray.sort((a,b) => {
            const titleA = a.taskTitle.toUpperCase();
            const titleB = b.taskTitle.toUpperCase();
            if (titleA < titleB){
              return -1;
            }
            if (titleA > titleB){
              return 1;
            }
            return 0;
          })

        }
      if(this.orderBy==="desc"){

        this.shownArray.sort((a,b) => {
          const titleA = a.taskTitle.toUpperCase();
          const titleB = b.taskTitle.toUpperCase();
          if (titleA > titleB){
            return -1;
          }
          if (titleA < titleB){
            return 1;
          }
          return 0;
        })

      }

    },
  },

  mounted() {
    this.getAll();
    this.getShown();
  },

};


</script>

<template>
  <title>To Do App</title>
  <div class="addtask">
    <button @click="newTask = !newTask">Add task</button>


  </div>
  <select name="filterbyname" id="" v-model="filterByStatus" @change="filterByDone">

    <option value="1">Completed</option>
    <option value="2">Not completed</option>
    <option value="3">No filter</option>

  </select>
  <button @click="filterByDone">Click on changes</button>

  <select name="orderby" id="" v-model="orderBy" @change="orderArray">
    <option value="asc">Ascending</option>
    <option value="desc">Descending</option>
  </select>

  <table>
    <tr>
      <td>Title</td>
      <td>Description</td>
      <td>Days left</td>
      <td>Status</td>
    </tr>
    <tr class="task" v-for="task in shownArray" :key="task.taskID">
      <td>{{task.taskTitle}}</td>
      <td>{{task.taskDescription}}</td>
      <td>{{task.taskDaysLeft}}</td>
      <td><input v-model="task.taskIsDone" type="checkbox" name="changeIsDone" id="changeIsDone" @change="updateIsDone(task)"></td>
      <td><input @click="pickItem(task)" type="button" value="pick"></td>
      <td><input @click="deleteItem(task)" type="submit" value="delete"></td>
    </tr>

  </table>

  <div v-for="pickedTask in pickedItem" :key="pickedTask.taskID" v-if="pickedItem">

    <input type="text" name="title" id="" v-model="pickedTask.taskTitle">
    <input type="text" name="title" id="" v-model="pickedTask.taskDescription">
    <input type="text" name="daysleft" id="" v-model="pickedTask.taskDaysLeft">
    <input type="checkbox" name="isdone" id="" v-model="pickedTask.taskIsDone">
    <input type="button" value="send" @click="updateTask(pickedTask)">
  </div>



  <div v-for="addTasks in addTask" v-if="newTask">
    <label for="title">Title</label><br>
    <input type="text" name="title" id="" v-model="addTasks.taskTitle"><br>
    <label for="desc">Description</label><br>
    <input type="text" name="desc" id="" v-model="addTasks.taskDescription"><br>
    <label for="daysleft">Days left</label><br>
    <input type="text" name="daysleft" id="" v-model="addTasks.taskDaysLeft"><br>
    <label for="isdone">Status</label><br>
    <input type="checkbox" name="isdone" id="" v-model="addTasks.taskIsDone"><br>
    <input type="submit" value="send" @click="sendNewTask(addTasks)">
  </div>



</template>

<style>
table{
  margin: 10px;
  border: 2px solid black;
  text-decoration: none;
  border-radius: 8px;
  width: 20%;
  padding: 2px;
  border-spacing: 0;
  border-collapse: collapse;
}
tr td{
  border: 2px solid black;

}
</style>
