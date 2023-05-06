import { Link } from 'react-router-dom';
import { useState, useEffect } from "react";
import axios from 'axios';

const AdminDashboardCourse = (props) => {

    const loggedInFlag = sessionStorage.getItem("user") == null;

    return (
        <div class="adminContainer">
            <div class="adminSidebar">
                <ol>
                    <li><Link to="/adminDashboard" class="links">Pending Approvals</Link></li>
                    <li><Link to="/adminDashboardCourse" class="links active">Course Stats</Link></li>
                    <li><Link to="/adminDashboardPayments" class="links">Payments History</Link></li>
                    {loggedInFlag ?
                        <li><Link to="/logout" class="links">Logout</Link></li> : null
                    }
                </ol>
            </div>
            {loggedInFlag ?
                <div class="courseContainer">
                    <h3>Courses</h3>
                    <div class="courseCardContainer">
                        <div class="courseCard">
                            <img src="/Images/mysql.svg" height='100px' width='100px' />
                            <div className='courseCardInfo'>
                                <h3>MySQL</h3>
                                <p>Subscribers: 20</p>
                                <Link to="/addToCourse" class="buy">Add New Chapter</Link>
                            </div>
                        </div>
                    </div>
                </div> :
                <div className='profileMainDiv'>
                    <form className='notLoggedIn'>
                        <h3>You are not logged in.</h3>
                        <Link to="/login" class="links">Click here to login?</Link>
                    </form>
                </div>
            }
        </div >
    );
}
export default AdminDashboardCourse;