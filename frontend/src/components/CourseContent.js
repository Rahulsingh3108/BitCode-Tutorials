import { Routes, Route } from "react-router-dom";
import { Link, Outlet } from 'react-router-dom';
import MySQLChapters from '../courseContents/MySQL/Chapters';
import Chapter1 from '../courseContents/MySQL/TypesOfPrimaryKeys';

const CourseContent = (props) => {
    return (
        <div className='courseContentPanel'>
            <div className='courseContentHeading'>
                <img src='/Images/mysql.svg' alt='MySQL Course' height='100px' width='100px' />
                <h3>MySQL</h3>
            </div>
            <div className='courseContent'>
                <MySQLChapters />
                <Outlet/>
            </div>
        </div>
    );
}
export default CourseContent;