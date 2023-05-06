import { Link } from 'react-router-dom';
import { useState, useEffect } from "react";
import axios from 'axios';

const Products = (props) => {

    const [apiData, setApiData] = useState([]);
    const [purcahsedCourses, setPurcahsedCourses] = useState([]);

    let user;
    let myCourseIds = [];
    let cartApi = { cartId: "", healthServiceId: "" }

    const setMyCourseIds = (value, index, array) => { myCourseIds.push(value.id); }

    useEffect(() => {

        user = JSON.parse(sessionStorage.getItem("user"));
        if (user == null) { user = { fullname: "", email: "", phone: "", dob: "", id: "" } }


        axios.get(`http://localhost:7072/helthify/user/userServices/${user.id}`)
            .then(response => {
                setPurcahsedCourses(response.data)
            });

        axios.get('http://localhost:7072/helthify/services')
            .then(response => {
                setApiData(response.data)
            });
    }, []);

    purcahsedCourses.forEach(setMyCourseIds);

    const addToCart = () => {
        axios.post('http://localhost:7072/helthify/cart/add', cartApi)
            .then(response => alert(response.data));
    }

    var courseCards = apiData.map(obj => {
        return (
            <div class="product">
                <div class="image">
                    <img src={obj.imagePath} alt="" />
                </div>
                <div class="description">
                    <h3>{obj.serviceName}</h3>
                    <p>{obj.mentor}</p>
                    <h2 class="price">{obj.price}</h2>
                    <Link to="/coursedetail" id={obj.id} onClick={() => localStorage.setItem("CourseId", obj.id)} class="buy">View</Link>
                    {myCourseIds.includes(obj.id) ?
                        <Link to="/coursedetail" className='add'>Go To Course</Link> :
                        <a onClick={() => {
                            user = JSON.parse(sessionStorage.getItem("user"));
                            cartApi.cartId = user.id;
                            cartApi.healthServiceId = obj.id;
                            addToCart();
                        }} class="add">Add to Cart</a>
                    }
                </div>
            </div>
        );
    });

    return (
        <>
            <div class="productSection1">
                <div class="main_container">
                    <div class="vertical_sec">
                        <div class="horizontal_sec">
                            <div class="box" id="box1">
                                <h3>Data Science</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea!
                                    Cum sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                            </div>
                            <div class="box" id="box2">
                                <h3>Business</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea!
                                    Cum sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                            </div>
                        </div>
                        <div class="horizontal_sec">
                            <div class="box" id="box3">
                                <h3>Computer Science</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea!
                                    Cum sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                            </div>
                            <div class="box" id="box4">
                                <h3>Information Tech</h3>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea!
                                    Cum sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                            </div>
                        </div>
                    </div>
                    <div class="vertical_sec">
                        <div class="box" id="box5">
                            <h3>Personal Development</h3>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci voluptate laboriosam ea! Cum
                                sint, reprehenderit quam laudantium quo quaerat cupiditate ipsum veniam</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="productSection2">
                <div class="productGrid">
                    {courseCards}
                </div>
            </div>
        </>
    );
}
export default Products;