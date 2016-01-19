/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.rockwellcollins.atc.limp.LimpPackage
 * @generated
 */
public interface LimpFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LimpFactory eINSTANCE = com.rockwellcollins.atc.limp.impl.LimpFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Specification</em>'.
   * @generated
   */
  Specification createSpecification();

  /**
   * Returns a new object of class '<em>Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Declaration</em>'.
   * @generated
   */
  Declaration createDeclaration();

  /**
   * Returns a new object of class '<em>Comment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Comment</em>'.
   * @generated
   */
  Comment createComment();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>External Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Function</em>'.
   * @generated
   */
  ExternalFunction createExternalFunction();

  /**
   * Returns a new object of class '<em>External Procedure</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Procedure</em>'.
   * @generated
   */
  ExternalProcedure createExternalProcedure();

  /**
   * Returns a new object of class '<em>Local Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Local Function</em>'.
   * @generated
   */
  LocalFunction createLocalFunction();

  /**
   * Returns a new object of class '<em>Local Procedure</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Local Procedure</em>'.
   * @generated
   */
  LocalProcedure createLocalProcedure();

  /**
   * Returns a new object of class '<em>Type Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Declaration</em>'.
   * @generated
   */
  TypeDeclaration createTypeDeclaration();

  /**
   * Returns a new object of class '<em>Var Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Block</em>'.
   * @generated
   */
  VarBlock createVarBlock();

  /**
   * Returns a new object of class '<em>Enum Type Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Type Def</em>'.
   * @generated
   */
  EnumTypeDef createEnumTypeDef();

  /**
   * Returns a new object of class '<em>Enum Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Value</em>'.
   * @generated
   */
  EnumValue createEnumValue();

  /**
   * Returns a new object of class '<em>Record Type Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Type Def</em>'.
   * @generated
   */
  RecordTypeDef createRecordTypeDef();

  /**
   * Returns a new object of class '<em>Array Type Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Type Def</em>'.
   * @generated
   */
  ArrayTypeDef createArrayTypeDef();

  /**
   * Returns a new object of class '<em>Abstract Type Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Type Def</em>'.
   * @generated
   */
  AbstractTypeDef createAbstractTypeDef();

  /**
   * Returns a new object of class '<em>Record Field Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Field Type</em>'.
   * @generated
   */
  RecordFieldType createRecordFieldType();

  /**
   * Returns a new object of class '<em>Constant Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant Declaration</em>'.
   * @generated
   */
  ConstantDeclaration createConstantDeclaration();

  /**
   * Returns a new object of class '<em>Global Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Global Declaration</em>'.
   * @generated
   */
  GlobalDeclaration createGlobalDeclaration();

  /**
   * Returns a new object of class '<em>Variable Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Ref</em>'.
   * @generated
   */
  VariableRef createVariableRef();

  /**
   * Returns a new object of class '<em>Input Arg List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Input Arg List</em>'.
   * @generated
   */
  InputArgList createInputArgList();

  /**
   * Returns a new object of class '<em>Input Arg</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Input Arg</em>'.
   * @generated
   */
  InputArg createInputArg();

  /**
   * Returns a new object of class '<em>Local Arg</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Local Arg</em>'.
   * @generated
   */
  LocalArg createLocalArg();

  /**
   * Returns a new object of class '<em>Output Arg List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Output Arg List</em>'.
   * @generated
   */
  OutputArgList createOutputArgList();

  /**
   * Returns a new object of class '<em>Output Arg</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Output Arg</em>'.
   * @generated
   */
  OutputArg createOutputArg();

  /**
   * Returns a new object of class '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type</em>'.
   * @generated
   */
  Type createType();

  /**
   * Returns a new object of class '<em>Attribute Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Block</em>'.
   * @generated
   */
  AttributeBlock createAttributeBlock();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Precondition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Precondition</em>'.
   * @generated
   */
  Precondition createPrecondition();

  /**
   * Returns a new object of class '<em>Postcondition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postcondition</em>'.
   * @generated
   */
  Postcondition createPostcondition();

  /**
   * Returns a new object of class '<em>Define Use Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Define Use Ref</em>'.
   * @generated
   */
  DefineUseRef createDefineUseRef();

  /**
   * Returns a new object of class '<em>Define</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Define</em>'.
   * @generated
   */
  Define createDefine();

  /**
   * Returns a new object of class '<em>Uses</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Uses</em>'.
   * @generated
   */
  Uses createUses();

  /**
   * Returns a new object of class '<em>Statement Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement Block</em>'.
   * @generated
   */
  StatementBlock createStatementBlock();

  /**
   * Returns a new object of class '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement</em>'.
   * @generated
   */
  Statement createStatement();

  /**
   * Returns a new object of class '<em>Void Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Void Statement</em>'.
   * @generated
   */
  VoidStatement createVoidStatement();

  /**
   * Returns a new object of class '<em>Assignment Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment Statement</em>'.
   * @generated
   */
  AssignmentStatement createAssignmentStatement();

  /**
   * Returns a new object of class '<em>If Then Else Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Then Else Statement</em>'.
   * @generated
   */
  IfThenElseStatement createIfThenElseStatement();

  /**
   * Returns a new object of class '<em>Else</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Else</em>'.
   * @generated
   */
  Else createElse();

  /**
   * Returns a new object of class '<em>While Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>While Statement</em>'.
   * @generated
   */
  WhileStatement createWhileStatement();

  /**
   * Returns a new object of class '<em>For Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>For Statement</em>'.
   * @generated
   */
  ForStatement createForStatement();

  /**
   * Returns a new object of class '<em>Label Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Label Statement</em>'.
   * @generated
   */
  LabelStatement createLabelStatement();

  /**
   * Returns a new object of class '<em>Goto Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Goto Statement</em>'.
   * @generated
   */
  GotoStatement createGotoStatement();

  /**
   * Returns a new object of class '<em>Equation Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equation Block</em>'.
   * @generated
   */
  EquationBlock createEquationBlock();

  /**
   * Returns a new object of class '<em>Equation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equation</em>'.
   * @generated
   */
  Equation createEquation();

  /**
   * Returns a new object of class '<em>Id List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Id List</em>'.
   * @generated
   */
  IdList createIdList();

  /**
   * Returns a new object of class '<em>Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expr</em>'.
   * @generated
   */
  Expr createExpr();

  /**
   * Returns a new object of class '<em>Function Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Ref</em>'.
   * @generated
   */
  FunctionRef createFunctionRef();

  /**
   * Returns a new object of class '<em>Array Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Expr</em>'.
   * @generated
   */
  ArrayExpr createArrayExpr();

  /**
   * Returns a new object of class '<em>Record Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Expr</em>'.
   * @generated
   */
  RecordExpr createRecordExpr();

  /**
   * Returns a new object of class '<em>Record Field Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Field Expr</em>'.
   * @generated
   */
  RecordFieldExpr createRecordFieldExpr();

  /**
   * Returns a new object of class '<em>Expr List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expr List</em>'.
   * @generated
   */
  ExprList createExprList();

  /**
   * Returns a new object of class '<em>Type Alias</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Alias</em>'.
   * @generated
   */
  TypeAlias createTypeAlias();

  /**
   * Returns a new object of class '<em>Some Var Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Some Var Block</em>'.
   * @generated
   */
  SomeVarBlock createSomeVarBlock();

  /**
   * Returns a new object of class '<em>No Var Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>No Var Block</em>'.
   * @generated
   */
  NoVarBlock createNoVarBlock();

  /**
   * Returns a new object of class '<em>Void Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Void Type</em>'.
   * @generated
   */
  VoidType createVoidType();

  /**
   * Returns a new object of class '<em>Bool Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bool Type</em>'.
   * @generated
   */
  BoolType createBoolType();

  /**
   * Returns a new object of class '<em>Integer Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Integer Type</em>'.
   * @generated
   */
  IntegerType createIntegerType();

  /**
   * Returns a new object of class '<em>Real Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Real Type</em>'.
   * @generated
   */
  RealType createRealType();

  /**
   * Returns a new object of class '<em>String Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Type</em>'.
   * @generated
   */
  StringType createStringType();

  /**
   * Returns a new object of class '<em>Enum Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Type</em>'.
   * @generated
   */
  EnumType createEnumType();

  /**
   * Returns a new object of class '<em>Record Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Type</em>'.
   * @generated
   */
  RecordType createRecordType();

  /**
   * Returns a new object of class '<em>Array Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Type</em>'.
   * @generated
   */
  ArrayType createArrayType();

  /**
   * Returns a new object of class '<em>Abstract Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Type</em>'.
   * @generated
   */
  AbstractType createAbstractType();

  /**
   * Returns a new object of class '<em>Named Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Type</em>'.
   * @generated
   */
  NamedType createNamedType();

  /**
   * Returns a new object of class '<em>Some Attribute Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Some Attribute Block</em>'.
   * @generated
   */
  SomeAttributeBlock createSomeAttributeBlock();

  /**
   * Returns a new object of class '<em>No Attribute Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>No Attribute Block</em>'.
   * @generated
   */
  NoAttributeBlock createNoAttributeBlock();

  /**
   * Returns a new object of class '<em>Break Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Break Statement</em>'.
   * @generated
   */
  BreakStatement createBreakStatement();

  /**
   * Returns a new object of class '<em>Continue Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Continue Statement</em>'.
   * @generated
   */
  ContinueStatement createContinueStatement();

  /**
   * Returns a new object of class '<em>Return Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Return Statement</em>'.
   * @generated
   */
  ReturnStatement createReturnStatement();

  /**
   * Returns a new object of class '<em>Else Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Else Block</em>'.
   * @generated
   */
  ElseBlock createElseBlock();

  /**
   * Returns a new object of class '<em>Else If</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Else If</em>'.
   * @generated
   */
  ElseIf createElseIf();

  /**
   * Returns a new object of class '<em>No Else</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>No Else</em>'.
   * @generated
   */
  NoElse createNoElse();

  /**
   * Returns a new object of class '<em>If Then Else Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Then Else Expr</em>'.
   * @generated
   */
  IfThenElseExpr createIfThenElseExpr();

  /**
   * Returns a new object of class '<em>Choice Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Choice Expr</em>'.
   * @generated
   */
  ChoiceExpr createChoiceExpr();

  /**
   * Returns a new object of class '<em>Binary Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary Expr</em>'.
   * @generated
   */
  BinaryExpr createBinaryExpr();

  /**
   * Returns a new object of class '<em>Unary Negation Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Negation Expr</em>'.
   * @generated
   */
  UnaryNegationExpr createUnaryNegationExpr();

  /**
   * Returns a new object of class '<em>Unary Minus Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Minus Expr</em>'.
   * @generated
   */
  UnaryMinusExpr createUnaryMinusExpr();

  /**
   * Returns a new object of class '<em>Record Access Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Access Expr</em>'.
   * @generated
   */
  RecordAccessExpr createRecordAccessExpr();

  /**
   * Returns a new object of class '<em>Record Update Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Update Expr</em>'.
   * @generated
   */
  RecordUpdateExpr createRecordUpdateExpr();

  /**
   * Returns a new object of class '<em>Array Access Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Access Expr</em>'.
   * @generated
   */
  ArrayAccessExpr createArrayAccessExpr();

  /**
   * Returns a new object of class '<em>Array Update Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Update Expr</em>'.
   * @generated
   */
  ArrayUpdateExpr createArrayUpdateExpr();

  /**
   * Returns a new object of class '<em>Boolean Literal Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Literal Expr</em>'.
   * @generated
   */
  BooleanLiteralExpr createBooleanLiteralExpr();

  /**
   * Returns a new object of class '<em>Integer Literal Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Integer Literal Expr</em>'.
   * @generated
   */
  IntegerLiteralExpr createIntegerLiteralExpr();

  /**
   * Returns a new object of class '<em>Integer Wild Card Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Integer Wild Card Expr</em>'.
   * @generated
   */
  IntegerWildCardExpr createIntegerWildCardExpr();

  /**
   * Returns a new object of class '<em>Real Literal Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Real Literal Expr</em>'.
   * @generated
   */
  RealLiteralExpr createRealLiteralExpr();

  /**
   * Returns a new object of class '<em>String Literal Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Literal Expr</em>'.
   * @generated
   */
  StringLiteralExpr createStringLiteralExpr();

  /**
   * Returns a new object of class '<em>Init Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Init Expr</em>'.
   * @generated
   */
  InitExpr createInitExpr();

  /**
   * Returns a new object of class '<em>Second Init</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Second Init</em>'.
   * @generated
   */
  SecondInit createSecondInit();

  /**
   * Returns a new object of class '<em>Id Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Id Expr</em>'.
   * @generated
   */
  IdExpr createIdExpr();

  /**
   * Returns a new object of class '<em>Fcn Call Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fcn Call Expr</em>'.
   * @generated
   */
  FcnCallExpr createFcnCallExpr();

  /**
   * Returns a new object of class '<em>Tuple Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple Type</em>'.
   * @generated
   */
  TupleType createTupleType();

  /**
   * Returns a new object of class '<em>Fresh Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fresh Variable</em>'.
   * @generated
   */
  FreshVariable createFreshVariable();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  LimpPackage getLimpPackage();

} //LimpFactory
