import axios from "axios";
const BASE_URL = "http://localhost:8080/employee";

class EmployeeService {
  //**Method to get data from api or database*/
  getAllEmployee() {
    return axios.get(BASE_URL);
  }

  //**Method to save employee */
  saveEmployee(employeeData) {
    return axios.post(BASE_URL, employeeData);
  }

  //** update employee */
  updateEmployee(id, employeeData) {
    return axios.put(`${BASE_URL}/${id}`, employeeData);
  }
  //**get employee by id */
  getEmployeeById(id) {
    return axios.get(`${BASE_URL}/${id}`);
  }
  //**delete employee */
  deleteEmployee(id) {
    return axios.delete(BASE_URL + "/" + id);
  }
}
export default new EmployeeService();
