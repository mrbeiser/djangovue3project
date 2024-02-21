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
    };
  },
  methods: {
    getAll() {
      axios.get("http://localhost:8080/api/tasks/showAll")
          .then((response)=> this.allTasks=response.data);
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


      this.allTasks.filter(filterByDone=>  filterByDone.taskIsDone === true);
      }



  },
  mounted() {
    this.getAll()
  },

};


</script>

<template>
  <title>To Do App</title>
  <div class="addtask">
    <button @click="newTask = !newTask">Add task</button>
    <!--
    <select name="filterbyname" id="" v-model="filterByStatus">
      <option disabled value="">Filter by status</option>
      <option value="1">Completed</option>
      <option value="2">Not completed</option>
      <option value="3">No filter</option>

    </select>{{filterByStatus}}
    <button @click="filterByDone">Filter</button> !-->
  </div>
  <table>
    <tr>
      <td>Title</td>
      <td>Description</td>
      <td>Days left</td>
      <td>Status</td>
    </tr>
  <tr class="task" v-for="task in allTasks" :key="task.taskID">
    <td>{{task.taskTitle}}</td>
    <td>{{task.taskDescription}}</td>
    <td>{{task.taskDaysLeft}}</td>
    <td><input v-model="task.taskIsDone" type="checkbox" name="changeIsDone" id="changeIsDone" @change="updateIsDone(task)"></td>
    <td><input @click="pickItem(task)" type="button" value="pick"></td>
    <td><input @click="deleteItem(task)" type="submit" value="delete"></td>
  </tr>

  </table>

  <div v-for="pickedTask in pickedItem" :key="pickedTask.taskID">

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
