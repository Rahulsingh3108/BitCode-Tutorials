import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from './components/Home';
import About from './components/About';
import Login from './components/Login';
import Signup from './components/Signup';
import Products from "./components/Products";
import ProfileEditInfo from "./components/ProfileEditInfo";
import ProfileCourses from "./components/ProfileCourses";
import ProfileSettings from "./components/ProfileSettings";
import CourseContent from "./components/CourseContent";
import CourseDetail from "./components/CourseDetail";
import Logout from "./components/Logout";
import Cart from "./components/Cart";
import AdminDashboard from "./components/AdminDashboard";
import AdminDashboardCourse from "./components/AdminDashboardCourse";
import AdminDashboardPayments from "./components/AdminDashboardPayments";
import AddToCourse from "./components/AddToCourse";
import PaymentsPage from "./components/PaymentsPage";

import Header from './components/Header';
import Footer from './components/Footer';

import Chapter1 from './courseContents/MySQL/TypesOfPrimaryKeys';
import Chapter2 from './courseContents/MySQL/TypesOfMySQLQueries';
import Chapter3 from './courseContents/MySQL/DatabaseOperations';
import Chapter4 from './courseContents/MySQL/ManagingTables';
import Chapter5 from './courseContents/MySQL/MySQLConstraints';

function App() {
  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route exact path="/about" element={<About />} />
        <Route exact path="/login" element={<Login />} />
        <Route exact path="/signup" element={<Signup />} />
        <Route exact path="/products" element={<Products />} />
        <Route exact path="/profile" element={<ProfileEditInfo />} />
        <Route exact path="/profileCourses" element={<ProfileCourses />} />
        <Route exact path="/profileSettings" element={<ProfileSettings />} />
        <Route path="/mysqlcourse" element={<CourseContent />}> 
          <Route path="chapter1" element={<Chapter1 />} />
          <Route path="chapter2" element={<Chapter2 />} />
          <Route path="chapter3" element={<Chapter3 />} />
          <Route path="chapter4" element={<Chapter4 />} />
          <Route path="chapter5" element={<Chapter5 />} />
        </Route>
        <Route exact path="/coursedetail" element={<CourseDetail />} />
        <Route exact path="/logout" element={<Logout />} />
        <Route exact path="/cart" element={<Cart />} />
        <Route exact path="/addToCourse" element={<AddToCourse />} />
        <Route exact path="/paymentsPage" element={<PaymentsPage />} />
        <Route exact path="/adminDashboard" element={<AdminDashboard />} />
        <Route exact path="/adminDashboardCourse" element={<AdminDashboardCourse />} />
        <Route exact path="/adminDashboardPayments" element={<AdminDashboardPayments />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
}

export default App;