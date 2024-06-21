import React, { Component } from "react";
import './board-user.component.css';
import UserService from "../services/user.service";
import EventBus from "../common/EventBus";
import { keyboard } from "@testing-library/user-event/dist/keyboard";




  const coursesData = [
  { id: 1, courseName: 'DAC', subject: 'Data Structure', assignment: 'Bubble Sort Implementation',grade: 'A+' },
  { id: 2, courseName: 'DAC', subject: 'Core Java', assignment: 'Inheritance and Abstraction',grade: 'A' },
  { id: 3, courseName: 'DAC', subject: 'Web Programming', assignment: 'Components in React JS',grade: 'B+' },
  
  // Add more courses here
];

const SApp = () => {
  return (
    <div className="container1">
      <h1>Student Portal Dashboard</h1>
      <table>
        <thead>
          <tr>
            <th>Course Name</th>
            <th>Subject</th>
            <th>Assignment</th>
            <th>Grade</th>
          </tr>
        </thead>
        <tbody>
          {coursesData.map(course => (
            <tr key={course.id}>
              <td>{course.courseName}</td>
              <td>{course.subject}</td>
              <td>{course.assignment}</td>
              <td>{course.grade}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};



  // constructor(props) {
  //   super(props);
  //   this.state = {
  //     courses: []
  //   };

  // }


  // componentDidMount() {
  //   UserService.getUserBoard()
  //     .then(
  //       response => {
  //         /**
  //          * This is the most importan step to understand here
  //          *  we can locate the nested objects through response.data 
  //          * response.data = Course object returns 
  //          * response.data.course = gives the values of the nested object
  //          */

  //         this.setState({
  //           allData: response.data.course,
  //         });


  //       },
  //       error => {
  //         this.setState({
  //           courses:
  //             (error.response &&
  //               error.response.data &&
  //               error.response.data.courses) ||
  //             error.courses ||
  //             error.toString()
  //         });

  //         if (error.response && error.response.status === 401) {
  //           EventBus.dispatch("logout");
  //         }
  //       }
  //     );

  // }




  // render() {

  //   let course = {
  //     id: "",
  //     title: "",
  //     passingGrade: "",
  //     semester: "",
  //     price: "",
  //     isPaid: "",
  //     hasAttendedECourses: "",
  //     assignment: ""
  //   }
  //   const listOfCourses = [];
  //   var valuesArray = this.state.allData;
  //    console.log("herer"+valuesArray);
  //   for (var key in valuesArray) {
  //     if (valuesArray.hasOwnProperty(key)) {
  //        console.log(key + " -> " + JSON.stringify(valuesArray[key]));
  //       course.passingGrade = 6.5;
  //       course = valuesArray[key];
  //       listOfCourses.push(course)
  //     }
  //   }
    
  //   return (
  //     <div className="container">
  //       <header className="jumbotron">

  //         <table class="table table-light">
  //           <thead>
  //             <tr>
  //               <th scope="col">Lessons</th>
  //               <th scope="col">Passing Grade</th>
  //               <th scope="col">Semester</th>
  //               <th scope="col">Price</th>
  //               <th scope="col">Status Of Payment</th>
  //               <th scope="col">Attended All Online Lessons</th>
  //               <th scope="col">Assignment Status</th>
  //               <th scope="col">Assignment Summary</th>
  //               <th scope="col">Assignment Deadline date</th>
  //               <th scope="col">To be implemented Pay the lesson</th>
  //             </tr>
  //           </thead>
  //           <tbody>
  //             {
  //               listOfCourses.map(
  //                 course =>
  //                   <tr key={course.id}>
  //                     <td> {course.title} </td>
  //                     <td>{course.passingGrade}</td>
  //                     <td> {course.semester} </td>
  //                     <td> {course.price} </td>
  //                     <td> {course.isPaid} </td>
  //                     <td> {course.hasAttendedECourses} </td>
  //                     <td> {course.assignment} </td>
  //                     <td> {course.isPaid} </td>
  //                   </tr>
  //               )
  //             }
  //           </tbody>
  //         </table>
        // </header>
//       </div>
//     );
//   }
 //}
 export default SApp;