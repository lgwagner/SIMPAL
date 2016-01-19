/**
 */
package com.rockwellcollins.atc.limp.util;

import com.rockwellcollins.atc.limp.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.rockwellcollins.atc.limp.LimpPackage
 * @generated
 */
public class LimpAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static LimpPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LimpAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = LimpPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LimpSwitch<Adapter> modelSwitch =
    new LimpSwitch<Adapter>()
    {
      @Override
      public Adapter caseSpecification(Specification object)
      {
        return createSpecificationAdapter();
      }
      @Override
      public Adapter caseDeclaration(Declaration object)
      {
        return createDeclarationAdapter();
      }
      @Override
      public Adapter caseComment(Comment object)
      {
        return createCommentAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseExternalFunction(ExternalFunction object)
      {
        return createExternalFunctionAdapter();
      }
      @Override
      public Adapter caseExternalProcedure(ExternalProcedure object)
      {
        return createExternalProcedureAdapter();
      }
      @Override
      public Adapter caseLocalFunction(LocalFunction object)
      {
        return createLocalFunctionAdapter();
      }
      @Override
      public Adapter caseLocalProcedure(LocalProcedure object)
      {
        return createLocalProcedureAdapter();
      }
      @Override
      public Adapter caseTypeDeclaration(TypeDeclaration object)
      {
        return createTypeDeclarationAdapter();
      }
      @Override
      public Adapter caseVarBlock(VarBlock object)
      {
        return createVarBlockAdapter();
      }
      @Override
      public Adapter caseEnumTypeDef(EnumTypeDef object)
      {
        return createEnumTypeDefAdapter();
      }
      @Override
      public Adapter caseEnumValue(EnumValue object)
      {
        return createEnumValueAdapter();
      }
      @Override
      public Adapter caseRecordTypeDef(RecordTypeDef object)
      {
        return createRecordTypeDefAdapter();
      }
      @Override
      public Adapter caseArrayTypeDef(ArrayTypeDef object)
      {
        return createArrayTypeDefAdapter();
      }
      @Override
      public Adapter caseAbstractTypeDef(AbstractTypeDef object)
      {
        return createAbstractTypeDefAdapter();
      }
      @Override
      public Adapter caseRecordFieldType(RecordFieldType object)
      {
        return createRecordFieldTypeAdapter();
      }
      @Override
      public Adapter caseConstantDeclaration(ConstantDeclaration object)
      {
        return createConstantDeclarationAdapter();
      }
      @Override
      public Adapter caseGlobalDeclaration(GlobalDeclaration object)
      {
        return createGlobalDeclarationAdapter();
      }
      @Override
      public Adapter caseVariableRef(VariableRef object)
      {
        return createVariableRefAdapter();
      }
      @Override
      public Adapter caseInputArgList(InputArgList object)
      {
        return createInputArgListAdapter();
      }
      @Override
      public Adapter caseInputArg(InputArg object)
      {
        return createInputArgAdapter();
      }
      @Override
      public Adapter caseLocalArg(LocalArg object)
      {
        return createLocalArgAdapter();
      }
      @Override
      public Adapter caseOutputArgList(OutputArgList object)
      {
        return createOutputArgListAdapter();
      }
      @Override
      public Adapter caseOutputArg(OutputArg object)
      {
        return createOutputArgAdapter();
      }
      @Override
      public Adapter caseType(Type object)
      {
        return createTypeAdapter();
      }
      @Override
      public Adapter caseAttributeBlock(AttributeBlock object)
      {
        return createAttributeBlockAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object)
      {
        return createAttributeAdapter();
      }
      @Override
      public Adapter casePrecondition(Precondition object)
      {
        return createPreconditionAdapter();
      }
      @Override
      public Adapter casePostcondition(Postcondition object)
      {
        return createPostconditionAdapter();
      }
      @Override
      public Adapter caseDefineUseRef(DefineUseRef object)
      {
        return createDefineUseRefAdapter();
      }
      @Override
      public Adapter caseDefine(Define object)
      {
        return createDefineAdapter();
      }
      @Override
      public Adapter caseUses(Uses object)
      {
        return createUsesAdapter();
      }
      @Override
      public Adapter caseStatementBlock(StatementBlock object)
      {
        return createStatementBlockAdapter();
      }
      @Override
      public Adapter caseStatement(Statement object)
      {
        return createStatementAdapter();
      }
      @Override
      public Adapter caseVoidStatement(VoidStatement object)
      {
        return createVoidStatementAdapter();
      }
      @Override
      public Adapter caseAssignmentStatement(AssignmentStatement object)
      {
        return createAssignmentStatementAdapter();
      }
      @Override
      public Adapter caseIfThenElseStatement(IfThenElseStatement object)
      {
        return createIfThenElseStatementAdapter();
      }
      @Override
      public Adapter caseElse(Else object)
      {
        return createElseAdapter();
      }
      @Override
      public Adapter caseWhileStatement(WhileStatement object)
      {
        return createWhileStatementAdapter();
      }
      @Override
      public Adapter caseForStatement(ForStatement object)
      {
        return createForStatementAdapter();
      }
      @Override
      public Adapter caseLabelStatement(LabelStatement object)
      {
        return createLabelStatementAdapter();
      }
      @Override
      public Adapter caseGotoStatement(GotoStatement object)
      {
        return createGotoStatementAdapter();
      }
      @Override
      public Adapter caseEquationBlock(EquationBlock object)
      {
        return createEquationBlockAdapter();
      }
      @Override
      public Adapter caseEquation(Equation object)
      {
        return createEquationAdapter();
      }
      @Override
      public Adapter caseIdList(IdList object)
      {
        return createIdListAdapter();
      }
      @Override
      public Adapter caseExpr(Expr object)
      {
        return createExprAdapter();
      }
      @Override
      public Adapter caseFunctionRef(FunctionRef object)
      {
        return createFunctionRefAdapter();
      }
      @Override
      public Adapter caseArrayExpr(ArrayExpr object)
      {
        return createArrayExprAdapter();
      }
      @Override
      public Adapter caseRecordExpr(RecordExpr object)
      {
        return createRecordExprAdapter();
      }
      @Override
      public Adapter caseRecordFieldExpr(RecordFieldExpr object)
      {
        return createRecordFieldExprAdapter();
      }
      @Override
      public Adapter caseExprList(ExprList object)
      {
        return createExprListAdapter();
      }
      @Override
      public Adapter caseTypeAlias(TypeAlias object)
      {
        return createTypeAliasAdapter();
      }
      @Override
      public Adapter caseSomeVarBlock(SomeVarBlock object)
      {
        return createSomeVarBlockAdapter();
      }
      @Override
      public Adapter caseNoVarBlock(NoVarBlock object)
      {
        return createNoVarBlockAdapter();
      }
      @Override
      public Adapter caseVoidType(VoidType object)
      {
        return createVoidTypeAdapter();
      }
      @Override
      public Adapter caseBoolType(BoolType object)
      {
        return createBoolTypeAdapter();
      }
      @Override
      public Adapter caseIntegerType(IntegerType object)
      {
        return createIntegerTypeAdapter();
      }
      @Override
      public Adapter caseRealType(RealType object)
      {
        return createRealTypeAdapter();
      }
      @Override
      public Adapter caseStringType(StringType object)
      {
        return createStringTypeAdapter();
      }
      @Override
      public Adapter caseEnumType(EnumType object)
      {
        return createEnumTypeAdapter();
      }
      @Override
      public Adapter caseRecordType(RecordType object)
      {
        return createRecordTypeAdapter();
      }
      @Override
      public Adapter caseArrayType(ArrayType object)
      {
        return createArrayTypeAdapter();
      }
      @Override
      public Adapter caseAbstractType(AbstractType object)
      {
        return createAbstractTypeAdapter();
      }
      @Override
      public Adapter caseNamedType(NamedType object)
      {
        return createNamedTypeAdapter();
      }
      @Override
      public Adapter caseSomeAttributeBlock(SomeAttributeBlock object)
      {
        return createSomeAttributeBlockAdapter();
      }
      @Override
      public Adapter caseNoAttributeBlock(NoAttributeBlock object)
      {
        return createNoAttributeBlockAdapter();
      }
      @Override
      public Adapter caseBreakStatement(BreakStatement object)
      {
        return createBreakStatementAdapter();
      }
      @Override
      public Adapter caseContinueStatement(ContinueStatement object)
      {
        return createContinueStatementAdapter();
      }
      @Override
      public Adapter caseReturnStatement(ReturnStatement object)
      {
        return createReturnStatementAdapter();
      }
      @Override
      public Adapter caseElseBlock(ElseBlock object)
      {
        return createElseBlockAdapter();
      }
      @Override
      public Adapter caseElseIf(ElseIf object)
      {
        return createElseIfAdapter();
      }
      @Override
      public Adapter caseNoElse(NoElse object)
      {
        return createNoElseAdapter();
      }
      @Override
      public Adapter caseIfThenElseExpr(IfThenElseExpr object)
      {
        return createIfThenElseExprAdapter();
      }
      @Override
      public Adapter caseChoiceExpr(ChoiceExpr object)
      {
        return createChoiceExprAdapter();
      }
      @Override
      public Adapter caseBinaryExpr(BinaryExpr object)
      {
        return createBinaryExprAdapter();
      }
      @Override
      public Adapter caseUnaryNegationExpr(UnaryNegationExpr object)
      {
        return createUnaryNegationExprAdapter();
      }
      @Override
      public Adapter caseUnaryMinusExpr(UnaryMinusExpr object)
      {
        return createUnaryMinusExprAdapter();
      }
      @Override
      public Adapter caseRecordAccessExpr(RecordAccessExpr object)
      {
        return createRecordAccessExprAdapter();
      }
      @Override
      public Adapter caseRecordUpdateExpr(RecordUpdateExpr object)
      {
        return createRecordUpdateExprAdapter();
      }
      @Override
      public Adapter caseArrayAccessExpr(ArrayAccessExpr object)
      {
        return createArrayAccessExprAdapter();
      }
      @Override
      public Adapter caseArrayUpdateExpr(ArrayUpdateExpr object)
      {
        return createArrayUpdateExprAdapter();
      }
      @Override
      public Adapter caseBooleanLiteralExpr(BooleanLiteralExpr object)
      {
        return createBooleanLiteralExprAdapter();
      }
      @Override
      public Adapter caseIntegerLiteralExpr(IntegerLiteralExpr object)
      {
        return createIntegerLiteralExprAdapter();
      }
      @Override
      public Adapter caseIntegerWildCardExpr(IntegerWildCardExpr object)
      {
        return createIntegerWildCardExprAdapter();
      }
      @Override
      public Adapter caseRealLiteralExpr(RealLiteralExpr object)
      {
        return createRealLiteralExprAdapter();
      }
      @Override
      public Adapter caseStringLiteralExpr(StringLiteralExpr object)
      {
        return createStringLiteralExprAdapter();
      }
      @Override
      public Adapter caseInitExpr(InitExpr object)
      {
        return createInitExprAdapter();
      }
      @Override
      public Adapter caseSecondInit(SecondInit object)
      {
        return createSecondInitAdapter();
      }
      @Override
      public Adapter caseIdExpr(IdExpr object)
      {
        return createIdExprAdapter();
      }
      @Override
      public Adapter caseFcnCallExpr(FcnCallExpr object)
      {
        return createFcnCallExprAdapter();
      }
      @Override
      public Adapter caseTupleType(TupleType object)
      {
        return createTupleTypeAdapter();
      }
      @Override
      public Adapter caseFreshVariable(FreshVariable object)
      {
        return createFreshVariableAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.Specification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.Specification
   * @generated
   */
  public Adapter createSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.Declaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.Declaration
   * @generated
   */
  public Adapter createDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.Comment <em>Comment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.Comment
   * @generated
   */
  public Adapter createCommentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ExternalFunction <em>External Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ExternalFunction
   * @generated
   */
  public Adapter createExternalFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ExternalProcedure <em>External Procedure</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ExternalProcedure
   * @generated
   */
  public Adapter createExternalProcedureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.LocalFunction <em>Local Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.LocalFunction
   * @generated
   */
  public Adapter createLocalFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.LocalProcedure <em>Local Procedure</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.LocalProcedure
   * @generated
   */
  public Adapter createLocalProcedureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.TypeDeclaration <em>Type Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.TypeDeclaration
   * @generated
   */
  public Adapter createTypeDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.VarBlock <em>Var Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.VarBlock
   * @generated
   */
  public Adapter createVarBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.EnumTypeDef <em>Enum Type Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.EnumTypeDef
   * @generated
   */
  public Adapter createEnumTypeDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.EnumValue <em>Enum Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.EnumValue
   * @generated
   */
  public Adapter createEnumValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.RecordTypeDef <em>Record Type Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.RecordTypeDef
   * @generated
   */
  public Adapter createRecordTypeDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ArrayTypeDef <em>Array Type Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ArrayTypeDef
   * @generated
   */
  public Adapter createArrayTypeDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.AbstractTypeDef <em>Abstract Type Def</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.AbstractTypeDef
   * @generated
   */
  public Adapter createAbstractTypeDefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.RecordFieldType <em>Record Field Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.RecordFieldType
   * @generated
   */
  public Adapter createRecordFieldTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ConstantDeclaration <em>Constant Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ConstantDeclaration
   * @generated
   */
  public Adapter createConstantDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.GlobalDeclaration <em>Global Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.GlobalDeclaration
   * @generated
   */
  public Adapter createGlobalDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.VariableRef <em>Variable Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.VariableRef
   * @generated
   */
  public Adapter createVariableRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.InputArgList <em>Input Arg List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.InputArgList
   * @generated
   */
  public Adapter createInputArgListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.InputArg <em>Input Arg</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.InputArg
   * @generated
   */
  public Adapter createInputArgAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.LocalArg <em>Local Arg</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.LocalArg
   * @generated
   */
  public Adapter createLocalArgAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.OutputArgList <em>Output Arg List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.OutputArgList
   * @generated
   */
  public Adapter createOutputArgListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.OutputArg <em>Output Arg</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.OutputArg
   * @generated
   */
  public Adapter createOutputArgAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.Type
   * @generated
   */
  public Adapter createTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.AttributeBlock <em>Attribute Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.AttributeBlock
   * @generated
   */
  public Adapter createAttributeBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.Precondition <em>Precondition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.Precondition
   * @generated
   */
  public Adapter createPreconditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.Postcondition <em>Postcondition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.Postcondition
   * @generated
   */
  public Adapter createPostconditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.DefineUseRef <em>Define Use Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.DefineUseRef
   * @generated
   */
  public Adapter createDefineUseRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.Define <em>Define</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.Define
   * @generated
   */
  public Adapter createDefineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.Uses <em>Uses</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.Uses
   * @generated
   */
  public Adapter createUsesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.StatementBlock <em>Statement Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.StatementBlock
   * @generated
   */
  public Adapter createStatementBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.Statement
   * @generated
   */
  public Adapter createStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.VoidStatement <em>Void Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.VoidStatement
   * @generated
   */
  public Adapter createVoidStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.AssignmentStatement <em>Assignment Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.AssignmentStatement
   * @generated
   */
  public Adapter createAssignmentStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.IfThenElseStatement <em>If Then Else Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.IfThenElseStatement
   * @generated
   */
  public Adapter createIfThenElseStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.Else <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.Else
   * @generated
   */
  public Adapter createElseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.WhileStatement <em>While Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.WhileStatement
   * @generated
   */
  public Adapter createWhileStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ForStatement <em>For Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ForStatement
   * @generated
   */
  public Adapter createForStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.LabelStatement <em>Label Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.LabelStatement
   * @generated
   */
  public Adapter createLabelStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.GotoStatement <em>Goto Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.GotoStatement
   * @generated
   */
  public Adapter createGotoStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.EquationBlock <em>Equation Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.EquationBlock
   * @generated
   */
  public Adapter createEquationBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.Equation <em>Equation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.Equation
   * @generated
   */
  public Adapter createEquationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.IdList <em>Id List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.IdList
   * @generated
   */
  public Adapter createIdListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.Expr
   * @generated
   */
  public Adapter createExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.FunctionRef <em>Function Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.FunctionRef
   * @generated
   */
  public Adapter createFunctionRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ArrayExpr <em>Array Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ArrayExpr
   * @generated
   */
  public Adapter createArrayExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.RecordExpr <em>Record Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.RecordExpr
   * @generated
   */
  public Adapter createRecordExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.RecordFieldExpr <em>Record Field Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.RecordFieldExpr
   * @generated
   */
  public Adapter createRecordFieldExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ExprList <em>Expr List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ExprList
   * @generated
   */
  public Adapter createExprListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.TypeAlias <em>Type Alias</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.TypeAlias
   * @generated
   */
  public Adapter createTypeAliasAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.SomeVarBlock <em>Some Var Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.SomeVarBlock
   * @generated
   */
  public Adapter createSomeVarBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.NoVarBlock <em>No Var Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.NoVarBlock
   * @generated
   */
  public Adapter createNoVarBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.VoidType <em>Void Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.VoidType
   * @generated
   */
  public Adapter createVoidTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.BoolType <em>Bool Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.BoolType
   * @generated
   */
  public Adapter createBoolTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.IntegerType <em>Integer Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.IntegerType
   * @generated
   */
  public Adapter createIntegerTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.RealType <em>Real Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.RealType
   * @generated
   */
  public Adapter createRealTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.StringType <em>String Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.StringType
   * @generated
   */
  public Adapter createStringTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.EnumType <em>Enum Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.EnumType
   * @generated
   */
  public Adapter createEnumTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.RecordType <em>Record Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.RecordType
   * @generated
   */
  public Adapter createRecordTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ArrayType <em>Array Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ArrayType
   * @generated
   */
  public Adapter createArrayTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.AbstractType <em>Abstract Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.AbstractType
   * @generated
   */
  public Adapter createAbstractTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.NamedType <em>Named Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.NamedType
   * @generated
   */
  public Adapter createNamedTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.SomeAttributeBlock <em>Some Attribute Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.SomeAttributeBlock
   * @generated
   */
  public Adapter createSomeAttributeBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.NoAttributeBlock <em>No Attribute Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.NoAttributeBlock
   * @generated
   */
  public Adapter createNoAttributeBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.BreakStatement <em>Break Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.BreakStatement
   * @generated
   */
  public Adapter createBreakStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ContinueStatement <em>Continue Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ContinueStatement
   * @generated
   */
  public Adapter createContinueStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ReturnStatement <em>Return Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ReturnStatement
   * @generated
   */
  public Adapter createReturnStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ElseBlock <em>Else Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ElseBlock
   * @generated
   */
  public Adapter createElseBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ElseIf <em>Else If</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ElseIf
   * @generated
   */
  public Adapter createElseIfAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.NoElse <em>No Else</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.NoElse
   * @generated
   */
  public Adapter createNoElseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.IfThenElseExpr <em>If Then Else Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.IfThenElseExpr
   * @generated
   */
  public Adapter createIfThenElseExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ChoiceExpr <em>Choice Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ChoiceExpr
   * @generated
   */
  public Adapter createChoiceExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.BinaryExpr <em>Binary Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.BinaryExpr
   * @generated
   */
  public Adapter createBinaryExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.UnaryNegationExpr <em>Unary Negation Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.UnaryNegationExpr
   * @generated
   */
  public Adapter createUnaryNegationExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.UnaryMinusExpr <em>Unary Minus Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.UnaryMinusExpr
   * @generated
   */
  public Adapter createUnaryMinusExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.RecordAccessExpr <em>Record Access Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.RecordAccessExpr
   * @generated
   */
  public Adapter createRecordAccessExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.RecordUpdateExpr <em>Record Update Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.RecordUpdateExpr
   * @generated
   */
  public Adapter createRecordUpdateExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ArrayAccessExpr <em>Array Access Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ArrayAccessExpr
   * @generated
   */
  public Adapter createArrayAccessExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.ArrayUpdateExpr <em>Array Update Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.ArrayUpdateExpr
   * @generated
   */
  public Adapter createArrayUpdateExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.BooleanLiteralExpr <em>Boolean Literal Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.BooleanLiteralExpr
   * @generated
   */
  public Adapter createBooleanLiteralExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.IntegerLiteralExpr <em>Integer Literal Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.IntegerLiteralExpr
   * @generated
   */
  public Adapter createIntegerLiteralExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.IntegerWildCardExpr <em>Integer Wild Card Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.IntegerWildCardExpr
   * @generated
   */
  public Adapter createIntegerWildCardExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.RealLiteralExpr <em>Real Literal Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.RealLiteralExpr
   * @generated
   */
  public Adapter createRealLiteralExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.StringLiteralExpr <em>String Literal Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.StringLiteralExpr
   * @generated
   */
  public Adapter createStringLiteralExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.InitExpr <em>Init Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.InitExpr
   * @generated
   */
  public Adapter createInitExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.SecondInit <em>Second Init</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.SecondInit
   * @generated
   */
  public Adapter createSecondInitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.IdExpr <em>Id Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.IdExpr
   * @generated
   */
  public Adapter createIdExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.FcnCallExpr <em>Fcn Call Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.FcnCallExpr
   * @generated
   */
  public Adapter createFcnCallExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.TupleType <em>Tuple Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.TupleType
   * @generated
   */
  public Adapter createTupleTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.rockwellcollins.atc.limp.FreshVariable <em>Fresh Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.rockwellcollins.atc.limp.FreshVariable
   * @generated
   */
  public Adapter createFreshVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //LimpAdapterFactory
