import { Link } from 'react-router-dom';
import { useState, useEffect } from "react";
import axios from 'axios';

const CourseDetail = (props) => {

    const [apiData, setApiData] = useState([]);
    const [courseDetails, setCourseDetails] = useState([]);
    useEffect(() => {
        const courseId = localStorage.getItem("CourseId");
        axios.get(`http://localhost:7072/helthify/services/${courseId}`)
            .then(response => { setApiData(response.data) });

        axios.get(`http://localhost:7072/helthify/courseDetails/${courseId}`)
            .then(response => { setCourseDetails(response.data) });
    }, []);

    let count = 0;
    var courseChapters = courseDetails.map(obj => {
        count++;
        return (
            <li>{count}. {obj.serviceDescription}</li>
        );
    });

    return (
        <div className='courseContentPanel'>
            <div className='courseContentHeading'>
                <img src={apiData.imagePath} alt='MySQL Course' height='100px' width='100px' />
                <h3>{apiData.serviceName}</h3>
            </div>
            <h4>Health Service Contents :</h4>
            <p>{apiData.description}</p>
            <div className='courseContentChaptersList'>
                <ol>
                    {courseChapters}
                </ol>
            </div>
        </div>
    );
}
export default CourseDetail;