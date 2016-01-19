/**
 */
package com.rockwellcollins.atc.limp.util;

import com.rockwellcollins.atc.limp.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.rockwellcollins.atc.limp.LimpPackage
 * @generated
 */
public class LimpSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static LimpPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LimpSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = LimpPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case LimpPackage.SPECIFICATION:
      {
        Specification specification = (Specification)theEObject;
        T result = caseSpecification(specification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.DECLARATION:
      {
        Declaration declaration = (Declaration)theEObject;
        T result = caseDeclaration(declaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.COMMENT:
      {
        Comment comment = (Comment)theEObject;
        T result = caseComment(comment);
        if (result == null) result = caseDeclaration(comment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = caseDeclaration(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.EXTERNAL_FUNCTION:
      {
        ExternalFunction externalFunction = (ExternalFunction)theEObject;
        T result = caseExternalFunction(externalFunction);
        if (result == null) result = caseDeclaration(externalFunction);
        if (result == null) result = caseFunctionRef(externalFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.EXTERNAL_PROCEDURE:
      {
        ExternalProcedure externalProcedure = (ExternalProcedure)theEObject;
        T result = caseExternalProcedure(externalProcedure);
        if (result == null) result = caseDeclaration(externalProcedure);
        if (result == null) result = caseFunctionRef(externalProcedure);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.LOCAL_FUNCTION:
      {
        LocalFunction localFunction = (LocalFunction)theEObject;
        T result = caseLocalFunction(localFunction);
        if (result == null) result = caseDeclaration(localFunction);
        if (result == null) result = caseFunctionRef(localFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.LOCAL_PROCEDURE:
      {
        LocalProcedure localProcedure = (LocalProcedure)theEObject;
        T result = caseLocalProcedure(localProcedure);
        if (result == null) result = caseDeclaration(localProcedure);
        if (result == null) result = caseFunctionRef(localProcedure);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.TYPE_DECLARATION:
      {
        TypeDeclaration typeDeclaration = (TypeDeclaration)theEObject;
        T result = caseTypeDeclaration(typeDeclaration);
        if (result == null) result = caseDeclaration(typeDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.VAR_BLOCK:
      {
        VarBlock varBlock = (VarBlock)theEObject;
        T result = caseVarBlock(varBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ENUM_TYPE_DEF:
      {
        EnumTypeDef enumTypeDef = (EnumTypeDef)theEObject;
        T result = caseEnumTypeDef(enumTypeDef);
        if (result == null) result = caseTypeDeclaration(enumTypeDef);
        if (result == null) result = caseDeclaration(enumTypeDef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ENUM_VALUE:
      {
        EnumValue enumValue = (EnumValue)theEObject;
        T result = caseEnumValue(enumValue);
        if (result == null) result = caseVariableRef(enumValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.RECORD_TYPE_DEF:
      {
        RecordTypeDef recordTypeDef = (RecordTypeDef)theEObject;
        T result = caseRecordTypeDef(recordTypeDef);
        if (result == null) result = caseTypeDeclaration(recordTypeDef);
        if (result == null) result = caseDeclaration(recordTypeDef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ARRAY_TYPE_DEF:
      {
        ArrayTypeDef arrayTypeDef = (ArrayTypeDef)theEObject;
        T result = caseArrayTypeDef(arrayTypeDef);
        if (result == null) result = caseTypeDeclaration(arrayTypeDef);
        if (result == null) result = caseDeclaration(arrayTypeDef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ABSTRACT_TYPE_DEF:
      {
        AbstractTypeDef abstractTypeDef = (AbstractTypeDef)theEObject;
        T result = caseAbstractTypeDef(abstractTypeDef);
        if (result == null) result = caseTypeDeclaration(abstractTypeDef);
        if (result == null) result = caseDeclaration(abstractTypeDef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.RECORD_FIELD_TYPE:
      {
        RecordFieldType recordFieldType = (RecordFieldType)theEObject;
        T result = caseRecordFieldType(recordFieldType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.CONSTANT_DECLARATION:
      {
        ConstantDeclaration constantDeclaration = (ConstantDeclaration)theEObject;
        T result = caseConstantDeclaration(constantDeclaration);
        if (result == null) result = caseDeclaration(constantDeclaration);
        if (result == null) result = caseVariableRef(constantDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.GLOBAL_DECLARATION:
      {
        GlobalDeclaration globalDeclaration = (GlobalDeclaration)theEObject;
        T result = caseGlobalDeclaration(globalDeclaration);
        if (result == null) result = caseDeclaration(globalDeclaration);
        if (result == null) result = caseVariableRef(globalDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.VARIABLE_REF:
      {
        VariableRef variableRef = (VariableRef)theEObject;
        T result = caseVariableRef(variableRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.INPUT_ARG_LIST:
      {
        InputArgList inputArgList = (InputArgList)theEObject;
        T result = caseInputArgList(inputArgList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.INPUT_ARG:
      {
        InputArg inputArg = (InputArg)theEObject;
        T result = caseInputArg(inputArg);
        if (result == null) result = caseVariableRef(inputArg);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.LOCAL_ARG:
      {
        LocalArg localArg = (LocalArg)theEObject;
        T result = caseLocalArg(localArg);
        if (result == null) result = caseVariableRef(localArg);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.OUTPUT_ARG_LIST:
      {
        OutputArgList outputArgList = (OutputArgList)theEObject;
        T result = caseOutputArgList(outputArgList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.OUTPUT_ARG:
      {
        OutputArg outputArg = (OutputArg)theEObject;
        T result = caseOutputArg(outputArg);
        if (result == null) result = caseVariableRef(outputArg);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.TYPE:
      {
        Type type = (Type)theEObject;
        T result = caseType(type);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ATTRIBUTE_BLOCK:
      {
        AttributeBlock attributeBlock = (AttributeBlock)theEObject;
        T result = caseAttributeBlock(attributeBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ATTRIBUTE:
      {
        Attribute attribute = (Attribute)theEObject;
        T result = caseAttribute(attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.PRECONDITION:
      {
        Precondition precondition = (Precondition)theEObject;
        T result = casePrecondition(precondition);
        if (result == null) result = caseAttribute(precondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.POSTCONDITION:
      {
        Postcondition postcondition = (Postcondition)theEObject;
        T result = casePostcondition(postcondition);
        if (result == null) result = caseAttribute(postcondition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.DEFINE_USE_REF:
      {
        DefineUseRef defineUseRef = (DefineUseRef)theEObject;
        T result = caseDefineUseRef(defineUseRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.DEFINE:
      {
        Define define = (Define)theEObject;
        T result = caseDefine(define);
        if (result == null) result = caseAttribute(define);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.USES:
      {
        Uses uses = (Uses)theEObject;
        T result = caseUses(uses);
        if (result == null) result = caseAttribute(uses);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.STATEMENT_BLOCK:
      {
        StatementBlock statementBlock = (StatementBlock)theEObject;
        T result = caseStatementBlock(statementBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.STATEMENT:
      {
        Statement statement = (Statement)theEObject;
        T result = caseStatement(statement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.VOID_STATEMENT:
      {
        VoidStatement voidStatement = (VoidStatement)theEObject;
        T result = caseVoidStatement(voidStatement);
        if (result == null) result = caseStatement(voidStatement);
        if (result == null) result = caseEquation(voidStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ASSIGNMENT_STATEMENT:
      {
        AssignmentStatement assignmentStatement = (AssignmentStatement)theEObject;
        T result = caseAssignmentStatement(assignmentStatement);
        if (result == null) result = caseStatement(assignmentStatement);
        if (result == null) result = caseEquation(assignmentStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.IF_THEN_ELSE_STATEMENT:
      {
        IfThenElseStatement ifThenElseStatement = (IfThenElseStatement)theEObject;
        T result = caseIfThenElseStatement(ifThenElseStatement);
        if (result == null) result = caseStatement(ifThenElseStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ELSE:
      {
        Else else_ = (Else)theEObject;
        T result = caseElse(else_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.WHILE_STATEMENT:
      {
        WhileStatement whileStatement = (WhileStatement)theEObject;
        T result = caseWhileStatement(whileStatement);
        if (result == null) result = caseStatement(whileStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.FOR_STATEMENT:
      {
        ForStatement forStatement = (ForStatement)theEObject;
        T result = caseForStatement(forStatement);
        if (result == null) result = caseStatement(forStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.LABEL_STATEMENT:
      {
        LabelStatement labelStatement = (LabelStatement)theEObject;
        T result = caseLabelStatement(labelStatement);
        if (result == null) result = caseStatement(labelStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.GOTO_STATEMENT:
      {
        GotoStatement gotoStatement = (GotoStatement)theEObject;
        T result = caseGotoStatement(gotoStatement);
        if (result == null) result = caseStatement(gotoStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.EQUATION_BLOCK:
      {
        EquationBlock equationBlock = (EquationBlock)theEObject;
        T result = caseEquationBlock(equationBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.EQUATION:
      {
        Equation equation = (Equation)theEObject;
        T result = caseEquation(equation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ID_LIST:
      {
        IdList idList = (IdList)theEObject;
        T result = caseIdList(idList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.EXPR:
      {
        Expr expr = (Expr)theEObject;
        T result = caseExpr(expr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.FUNCTION_REF:
      {
        FunctionRef functionRef = (FunctionRef)theEObject;
        T result = caseFunctionRef(functionRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ARRAY_EXPR:
      {
        ArrayExpr arrayExpr = (ArrayExpr)theEObject;
        T result = caseArrayExpr(arrayExpr);
        if (result == null) result = caseExpr(arrayExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.RECORD_EXPR:
      {
        RecordExpr recordExpr = (RecordExpr)theEObject;
        T result = caseRecordExpr(recordExpr);
        if (result == null) result = caseExpr(recordExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.RECORD_FIELD_EXPR:
      {
        RecordFieldExpr recordFieldExpr = (RecordFieldExpr)theEObject;
        T result = caseRecordFieldExpr(recordFieldExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.EXPR_LIST:
      {
        ExprList exprList = (ExprList)theEObject;
        T result = caseExprList(exprList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.TYPE_ALIAS:
      {
        TypeAlias typeAlias = (TypeAlias)theEObject;
        T result = caseTypeAlias(typeAlias);
        if (result == null) result = caseTypeDeclaration(typeAlias);
        if (result == null) result = caseDeclaration(typeAlias);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.SOME_VAR_BLOCK:
      {
        SomeVarBlock someVarBlock = (SomeVarBlock)theEObject;
        T result = caseSomeVarBlock(someVarBlock);
        if (result == null) result = caseVarBlock(someVarBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.NO_VAR_BLOCK:
      {
        NoVarBlock noVarBlock = (NoVarBlock)theEObject;
        T result = caseNoVarBlock(noVarBlock);
        if (result == null) result = caseVarBlock(noVarBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.VOID_TYPE:
      {
        VoidType voidType = (VoidType)theEObject;
        T result = caseVoidType(voidType);
        if (result == null) result = caseType(voidType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.BOOL_TYPE:
      {
        BoolType boolType = (BoolType)theEObject;
        T result = caseBoolType(boolType);
        if (result == null) result = caseType(boolType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.INTEGER_TYPE:
      {
        IntegerType integerType = (IntegerType)theEObject;
        T result = caseIntegerType(integerType);
        if (result == null) result = caseType(integerType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.REAL_TYPE:
      {
        RealType realType = (RealType)theEObject;
        T result = caseRealType(realType);
        if (result == null) result = caseType(realType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.STRING_TYPE:
      {
        StringType stringType = (StringType)theEObject;
        T result = caseStringType(stringType);
        if (result == null) result = caseType(stringType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ENUM_TYPE:
      {
        EnumType enumType = (EnumType)theEObject;
        T result = caseEnumType(enumType);
        if (result == null) result = caseType(enumType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.RECORD_TYPE:
      {
        RecordType recordType = (RecordType)theEObject;
        T result = caseRecordType(recordType);
        if (result == null) result = caseType(recordType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ARRAY_TYPE:
      {
        ArrayType arrayType = (ArrayType)theEObject;
        T result = caseArrayType(arrayType);
        if (result == null) result = caseType(arrayType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ABSTRACT_TYPE:
      {
        AbstractType abstractType = (AbstractType)theEObject;
        T result = caseAbstractType(abstractType);
        if (result == null) result = caseType(abstractType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.NAMED_TYPE:
      {
        NamedType namedType = (NamedType)theEObject;
        T result = caseNamedType(namedType);
        if (result == null) result = caseType(namedType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.SOME_ATTRIBUTE_BLOCK:
      {
        SomeAttributeBlock someAttributeBlock = (SomeAttributeBlock)theEObject;
        T result = caseSomeAttributeBlock(someAttributeBlock);
        if (result == null) result = caseAttributeBlock(someAttributeBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.NO_ATTRIBUTE_BLOCK:
      {
        NoAttributeBlock noAttributeBlock = (NoAttributeBlock)theEObject;
        T result = caseNoAttributeBlock(noAttributeBlock);
        if (result == null) result = caseAttributeBlock(noAttributeBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.BREAK_STATEMENT:
      {
        BreakStatement breakStatement = (BreakStatement)theEObject;
        T result = caseBreakStatement(breakStatement);
        if (result == null) result = caseStatement(breakStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.CONTINUE_STATEMENT:
      {
        ContinueStatement continueStatement = (ContinueStatement)theEObject;
        T result = caseContinueStatement(continueStatement);
        if (result == null) result = caseStatement(continueStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.RETURN_STATEMENT:
      {
        ReturnStatement returnStatement = (ReturnStatement)theEObject;
        T result = caseReturnStatement(returnStatement);
        if (result == null) result = caseStatement(returnStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ELSE_BLOCK:
      {
        ElseBlock elseBlock = (ElseBlock)theEObject;
        T result = caseElseBlock(elseBlock);
        if (result == null) result = caseElse(elseBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ELSE_IF:
      {
        ElseIf elseIf = (ElseIf)theEObject;
        T result = caseElseIf(elseIf);
        if (result == null) result = caseElse(elseIf);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.NO_ELSE:
      {
        NoElse noElse = (NoElse)theEObject;
        T result = caseNoElse(noElse);
        if (result == null) result = caseElse(noElse);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.IF_THEN_ELSE_EXPR:
      {
        IfThenElseExpr ifThenElseExpr = (IfThenElseExpr)theEObject;
        T result = caseIfThenElseExpr(ifThenElseExpr);
        if (result == null) result = caseExpr(ifThenElseExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.CHOICE_EXPR:
      {
        ChoiceExpr choiceExpr = (ChoiceExpr)theEObject;
        T result = caseChoiceExpr(choiceExpr);
        if (result == null) result = caseExpr(choiceExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.BINARY_EXPR:
      {
        BinaryExpr binaryExpr = (BinaryExpr)theEObject;
        T result = caseBinaryExpr(binaryExpr);
        if (result == null) result = caseExpr(binaryExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.UNARY_NEGATION_EXPR:
      {
        UnaryNegationExpr unaryNegationExpr = (UnaryNegationExpr)theEObject;
        T result = caseUnaryNegationExpr(unaryNegationExpr);
        if (result == null) result = caseExpr(unaryNegationExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.UNARY_MINUS_EXPR:
      {
        UnaryMinusExpr unaryMinusExpr = (UnaryMinusExpr)theEObject;
        T result = caseUnaryMinusExpr(unaryMinusExpr);
        if (result == null) result = caseExpr(unaryMinusExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.RECORD_ACCESS_EXPR:
      {
        RecordAccessExpr recordAccessExpr = (RecordAccessExpr)theEObject;
        T result = caseRecordAccessExpr(recordAccessExpr);
        if (result == null) result = caseExpr(recordAccessExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.RECORD_UPDATE_EXPR:
      {
        RecordUpdateExpr recordUpdateExpr = (RecordUpdateExpr)theEObject;
        T result = caseRecordUpdateExpr(recordUpdateExpr);
        if (result == null) result = caseExpr(recordUpdateExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ARRAY_ACCESS_EXPR:
      {
        ArrayAccessExpr arrayAccessExpr = (ArrayAccessExpr)theEObject;
        T result = caseArrayAccessExpr(arrayAccessExpr);
        if (result == null) result = caseExpr(arrayAccessExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ARRAY_UPDATE_EXPR:
      {
        ArrayUpdateExpr arrayUpdateExpr = (ArrayUpdateExpr)theEObject;
        T result = caseArrayUpdateExpr(arrayUpdateExpr);
        if (result == null) result = caseExpr(arrayUpdateExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.BOOLEAN_LITERAL_EXPR:
      {
        BooleanLiteralExpr booleanLiteralExpr = (BooleanLiteralExpr)theEObject;
        T result = caseBooleanLiteralExpr(booleanLiteralExpr);
        if (result == null) result = caseExpr(booleanLiteralExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.INTEGER_LITERAL_EXPR:
      {
        IntegerLiteralExpr integerLiteralExpr = (IntegerLiteralExpr)theEObject;
        T result = caseIntegerLiteralExpr(integerLiteralExpr);
        if (result == null) result = caseExpr(integerLiteralExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.INTEGER_WILD_CARD_EXPR:
      {
        IntegerWildCardExpr integerWildCardExpr = (IntegerWildCardExpr)theEObject;
        T result = caseIntegerWildCardExpr(integerWildCardExpr);
        if (result == null) result = caseExpr(integerWildCardExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.REAL_LITERAL_EXPR:
      {
        RealLiteralExpr realLiteralExpr = (RealLiteralExpr)theEObject;
        T result = caseRealLiteralExpr(realLiteralExpr);
        if (result == null) result = caseExpr(realLiteralExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.STRING_LITERAL_EXPR:
      {
        StringLiteralExpr stringLiteralExpr = (StringLiteralExpr)theEObject;
        T result = caseStringLiteralExpr(stringLiteralExpr);
        if (result == null) result = caseExpr(stringLiteralExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.INIT_EXPR:
      {
        InitExpr initExpr = (InitExpr)theEObject;
        T result = caseInitExpr(initExpr);
        if (result == null) result = caseExpr(initExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.SECOND_INIT:
      {
        SecondInit secondInit = (SecondInit)theEObject;
        T result = caseSecondInit(secondInit);
        if (result == null) result = caseExpr(secondInit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.ID_EXPR:
      {
        IdExpr idExpr = (IdExpr)theEObject;
        T result = caseIdExpr(idExpr);
        if (result == null) result = caseExpr(idExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.FCN_CALL_EXPR:
      {
        FcnCallExpr fcnCallExpr = (FcnCallExpr)theEObject;
        T result = caseFcnCallExpr(fcnCallExpr);
        if (result == null) result = caseExpr(fcnCallExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.TUPLE_TYPE:
      {
        TupleType tupleType = (TupleType)theEObject;
        T result = caseTupleType(tupleType);
        if (result == null) result = caseType(tupleType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case LimpPackage.FRESH_VARIABLE:
      {
        FreshVariable freshVariable = (FreshVariable)theEObject;
        T result = caseFreshVariable(freshVariable);
        if (result == null) result = caseExpr(freshVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpecification(Specification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclaration(Declaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Comment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Comment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComment(Comment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>External Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>External Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExternalFunction(ExternalFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>External Procedure</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>External Procedure</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExternalProcedure(ExternalProcedure object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Local Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Local Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLocalFunction(LocalFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Local Procedure</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Local Procedure</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLocalProcedure(LocalProcedure object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeDeclaration(TypeDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarBlock(VarBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Type Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Type Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumTypeDef(EnumTypeDef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumValue(EnumValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Type Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Type Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordTypeDef(RecordTypeDef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Type Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Type Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayTypeDef(ArrayTypeDef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Type Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Type Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractTypeDef(AbstractTypeDef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Field Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Field Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordFieldType(RecordFieldType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstantDeclaration(ConstantDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Global Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Global Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGlobalDeclaration(GlobalDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableRef(VariableRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Input Arg List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Input Arg List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInputArgList(InputArgList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Input Arg</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Input Arg</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInputArg(InputArg object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Local Arg</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Local Arg</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLocalArg(LocalArg object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Output Arg List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Output Arg List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutputArgList(OutputArgList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Output Arg</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Output Arg</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutputArg(OutputArg object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeBlock(AttributeBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute(Attribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Precondition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Precondition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrecondition(Precondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postcondition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postcondition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostcondition(Postcondition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Define Use Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Define Use Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefineUseRef(DefineUseRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Define</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Define</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefine(Define object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Uses</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Uses</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUses(Uses object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatementBlock(StatementBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatement(Statement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Void Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Void Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVoidStatement(VoidStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assignment Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignment Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignmentStatement(AssignmentStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Then Else Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Then Else Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfThenElseStatement(IfThenElseStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Else</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Else</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElse(Else object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>While Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>While Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhileStatement(WhileStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>For Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>For Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForStatement(ForStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Label Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Label Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLabelStatement(LabelStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Goto Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Goto Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGotoStatement(GotoStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equation Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equation Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEquationBlock(EquationBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEquation(Equation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Id List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Id List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIdList(IdList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpr(Expr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionRef(FunctionRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayExpr(ArrayExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordExpr(RecordExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Field Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Field Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordFieldExpr(RecordFieldExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expr List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expr List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExprList(ExprList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Alias</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Alias</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeAlias(TypeAlias object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Some Var Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Some Var Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSomeVarBlock(SomeVarBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>No Var Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>No Var Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNoVarBlock(NoVarBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Void Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Void Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVoidType(VoidType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bool Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bool Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBoolType(BoolType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerType(IntegerType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Real Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Real Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRealType(RealType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringType(StringType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumType(EnumType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordType(RecordType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayType(ArrayType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractType(AbstractType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedType(NamedType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Some Attribute Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Some Attribute Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSomeAttributeBlock(SomeAttributeBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>No Attribute Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>No Attribute Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNoAttributeBlock(NoAttributeBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Break Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Break Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBreakStatement(BreakStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Continue Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Continue Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContinueStatement(ContinueStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Return Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Return Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReturnStatement(ReturnStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Else Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Else Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElseBlock(ElseBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Else If</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Else If</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElseIf(ElseIf object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>No Else</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>No Else</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNoElse(NoElse object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Then Else Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Then Else Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfThenElseExpr(IfThenElseExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Choice Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Choice Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseChoiceExpr(ChoiceExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binary Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binary Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinaryExpr(BinaryExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Negation Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Negation Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryNegationExpr(UnaryNegationExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Minus Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Minus Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryMinusExpr(UnaryMinusExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Access Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Access Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordAccessExpr(RecordAccessExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Update Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Update Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordUpdateExpr(RecordUpdateExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Access Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Access Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayAccessExpr(ArrayAccessExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Update Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Update Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayUpdateExpr(ArrayUpdateExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Literal Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanLiteralExpr(BooleanLiteralExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Literal Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Literal Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerLiteralExpr(IntegerLiteralExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Wild Card Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Wild Card Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerWildCardExpr(IntegerWildCardExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Real Literal Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Real Literal Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRealLiteralExpr(RealLiteralExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Literal Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Literal Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringLiteralExpr(StringLiteralExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Init Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Init Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInitExpr(InitExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Second Init</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Second Init</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSecondInit(SecondInit object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Id Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Id Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIdExpr(IdExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fcn Call Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fcn Call Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFcnCallExpr(FcnCallExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTupleType(TupleType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fresh Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fresh Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFreshVariable(FreshVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //LimpSwitch
