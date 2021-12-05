package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeImplTest extends AnyFunSuite{
  val employeeValidator = mock[EmployeeValidator]
  val Faisal:Employee = new Employee("Mohd","Faisal",22,15000,"Intern","Knoldus","mohd.faisal@knoldus.com")
  val userImpl = new EmployeeImpl(employeeValidator)

  test("User can be ceated"){
    when(employeeValidator.employeeIsValid(Faisal)) thenReturn(true)
    val result = userImpl.createEmployee(Faisal)
    assert(result.isDefined)
  }
  test("User can not be created"){
    when(employeeValidator.employeeIsValid(Faisal)) thenReturn(false)
    val result = userImpl.createEmployee(Faisal)
    assert(result.isEmpty)
  }
}